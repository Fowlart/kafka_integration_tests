package test_cases;

import avro_pojos.CustomerTransactionsSummary;
import avro_pojos.OrderHeaderConsolidated;
import avro_pojos.OrderTenderDetailsEvents;
import avro_pojos.Rule;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;
import org.apache.commons.compress.utils.Lists;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import test_utils.RuleGenerator;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProduceDataAtInputTopics {

    private static long usaId = new Date().getTime();

    private static final MyKafkaProducer<String, OrderHeaderConsolidated> orderHeaderConsolidatedMyKafkaProducer =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForLocalProducer());

    private static final MyKafkaProducer<String, OrderTenderDetailsEvents> orderTenderDetailsEventsMyKafkaProducer =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForLocalProducer());

    private MyKafkaProducer<String, Rule> ruleProducer =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForLocalProducer());

    KafkaConsumer<String, CustomerTransactionsSummary> consumer =
            new KafkaConsumer<>(PropertiesUtil.getPropertiesForLocalConsumer("DataPlatformCreditCardDPPreScreen"));

    private static final Logger logger = LoggerFactory.getLogger(ProduceDataAtInputTopics.class);

     private OrderTenderDetailsEvents getTender(String orderNumber,
                                                      String date,
                                                      String transType) {

        return OrderTenderDetailsEvents
                .newBuilder()
                .setOrderNumber(orderNumber)
                .setCardNumber("333")
                .setTransactionType(transType)
                .setOrderSubmitDate(date)
                .setOrderSubmitDatetimeLocal(date)
                .build();
    }

    private  OrderHeaderConsolidated getOrder(String orderNumber, String date, String transType) {
        return OrderHeaderConsolidated
                .newBuilder()
                .setOrderNumber(orderNumber)
                .setUsaId(usaId)
                .setSephoraId(12348L)
                .setTransactionType(transType)
                .setOrderSubmitDate(date)
                .setChannelType("SEPHORA")
                .build();
    }

    @BeforeAll
    public void prepareTest() {

        consumer.subscribe(Collections.singleton("Sephora.DataPlatform.ReturnAuth.CustomerSummary"));

        RuleGenerator.getRules().forEach(rule -> ruleProducer.produceRecord(rule.getRuleId(), rule,
                "Sephora.DataPlatform.ReturnAuth.RulesManage", 1));
    }

    @Test
    public void testMainFlow() {

        String time = "2022-06-04";

        List<OrderHeaderConsolidated> sales = Lists.newArrayList();
        List<OrderHeaderConsolidated> returns = Lists.newArrayList();
        List<OrderTenderDetailsEvents> tenders = Lists.newArrayList();

        IntStream.range(0, 25).forEach(i -> {
            String orderNum = Long.toString(new Date().getTime() + i);
            sales.add(getOrder(orderNum, time, "S"));
            if (i <= 23) returns.add(getOrder(orderNum, time, "R"));
            tenders.add(getTender(orderNum, time, "S"));
        });

        assert  (returns.size() == 24);
        assert (sales.size() == 25);

        sales.forEach(sale -> orderHeaderConsolidatedMyKafkaProducer.produceRecord(sale.getOrderNumber(),
                sale,
                "Sephora.DataPlatform.ReturnAuth.OrderHeaderConsolidated", 1));

        returns.forEach(ret -> orderHeaderConsolidatedMyKafkaProducer.produceRecord(ret.getOrderNumber(),
                ret,
                "Sephora.DataPlatform.ReturnAuth.OrderHeaderConsolidated", 1));

        tenders.forEach(ten -> orderTenderDetailsEventsMyKafkaProducer.produceRecord(ten.getOrderNumber(),
                ten,
                "Sephora.DataPlatform.ReturnAuth.OrderTenderDetailsEvents", 1));

        int numOfRecords = 0;
        while (numOfRecords !=3) {
            numOfRecords++;
            ConsumerRecords<String, CustomerTransactionsSummary> consumerRecords = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, CustomerTransactionsSummary> cr : consumerRecords) {
                CustomerTransactionsSummary result = cr.value();
                logger.info(() -> "key: " + cr.key() + "| \n \n \n value: " + result);
                assert Arrays.stream("W P".split(" ")).anyMatch(status->status.equals(result.getReturnAuthFlag()));
            }
            consumer.commitSync();

        }
    }
}