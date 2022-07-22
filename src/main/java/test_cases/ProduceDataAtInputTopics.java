package test_cases;

import avro_pojos.OrderHeaderConsolidated;
import avro_pojos.OrderTenderDetailsEvents;
import avro_pojos.Rule;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;
import org.apache.commons.compress.utils.Lists;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import test_utils.RuleGenerator;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProduceDataAtInputTopics {

    private static final long usaId = new Date().getTime();

    private static final MyKafkaProducer<String, OrderHeaderConsolidated> orderHeaderConsolidatedMyKafkaProducer =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForLocalProducer());

    private static final MyKafkaProducer<String, OrderTenderDetailsEvents> orderTenderDetailsEventsMyKafkaProducer =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForLocalProducer());
    private static final Logger logger = LoggerFactory.getLogger(ProduceDataAtInputTopics.class);
    KafkaConsumer<String, org.apache.avro.generic.GenericData.Record> consumer =
            new KafkaConsumer<>(PropertiesUtil.getPropertiesForLocalConsumer("DataPlatformCreditCardDPPreScreen"));
    private final MyKafkaProducer<String, Rule> ruleProducer =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForLocalProducer());

    private OrderTenderDetailsEvents getTender(String orderNumber,
                                               String date,
                                               String transType) {

        return OrderTenderDetailsEvents
                .newBuilder()
                .setOrderNumber(orderNumber)
                .setCardNumber("333")
                .setTransactionType(transType)
                .setOrderSubmitDate(date)
                .build();
    }

    private OrderHeaderConsolidated getOrder(String orderNumber, String date, String dateTime, String transType) {
        return OrderHeaderConsolidated
                .newBuilder()
                .setOrderNumber(orderNumber)
                .setUsaId(usaId)
                .setSephoraId(12348L)
                .setTransactionType(transType)
                .setOrderSubmitDate(date)
                .setOrderSubmitDatetime(dateTime)
                .setChannelType("SEPHORA")
                .build();
    }

    @BeforeAll
    public void prepareTest() {

        consumer.subscribe(Collections.singleton("Sephora.DataPlatform.ReturnAuth.CustomerSummary"));

        RuleGenerator.getRules().forEach(rule -> ruleProducer.produceRecord(rule.getRuleId(), rule,
                "Sephora.DataPlatform.ReturnAuth.RulesManage", 1));
    }

    private String getCurrentTimeStamp(String format) {
        SimpleDateFormat sdfDate = new SimpleDateFormat(format);
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    @Test
    public void testMainFlow() {

        String date = getCurrentTimeStamp("yyyy-MM-dd");
        String dateTime = getCurrentTimeStamp("yyyy-MM-dd HH:mm:ss");

        List<OrderHeaderConsolidated> returns = Lists.newArrayList();

        IntStream.range(0, 25).forEach(i -> {
            String orderNum = Long.toString(new Date().getTime() + i);
            OrderHeaderConsolidated order = getOrder(orderNum, date, dateTime, "S");
            OrderTenderDetailsEvents tender = getTender(orderNum, date, "S");

            orderTenderDetailsEventsMyKafkaProducer.produceRecord(tender.getOrderNumber(),
                    tender,
                    "Sephora.DataPlatform.ReturnAuth.OrderTenderDetailsEvents", 1);

            orderHeaderConsolidatedMyKafkaProducer.produceRecord(order.getOrderNumber(),
                    order,
                    "Sephora.DataPlatform.ReturnAuth.OrderHeaderConsolidated", 1);

            if (i <= 23) returns.add(getOrder(orderNum, date, dateTime, "R"));
        });

        returns.forEach(ret -> orderHeaderConsolidatedMyKafkaProducer.produceRecord(ret.getOrderNumber(),
                ret,
                "Sephora.DataPlatform.ReturnAuth.OrderHeaderConsolidated", 1));

        List<org.apache.avro.generic.GenericData.Record> results = Lists.newArrayList();

        ConsumerRecords<String, org.apache.avro.generic.GenericData.Record> consumerRecords = consumer.poll(Duration.ofSeconds(15));
        for (ConsumerRecord<String, org.apache.avro.generic.GenericData.Record> cr : consumerRecords) {
            org.apache.avro.generic.GenericData.Record received = cr.value();
            results.add(received);
            logger.info(() -> "key: " + cr.key() + "| \n \n \n value: " + received);
        }
        if (!results.isEmpty()) consumer.commitSync();
        Function<org.apache.avro.generic.GenericData.Record, String> mapper = rec -> (String) rec.get("return_auth_flag");
        Assertions.assertTrue(results.stream().map(mapper).anyMatch(str->"P".equals(str) || "W".equals(str)));
    }
}