package kafka;

import avro_pojos.OrderHeaderConsolidated;
import avro_pojos.OrderTenderDetailsEvents;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class TestLocal {

    private static final Logger logger = LoggerFactory.getLogger(TestLocal.class);

    private static Properties getProperties(String filePath) {

        final Properties propsFromFile = new Properties();

        try (InputStream input = new FileInputStream(filePath)) {
            propsFromFile.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        final Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, propsFromFile.getProperty("kafka.server"));
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, propsFromFile.getProperty("schema-registry.server"));
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);

        return props;
    }

    public static <K, V> void produceRecord(K key, V record, String topic, int times) {

        KafkaProducer<K, V> producer = new KafkaProducer<>(getProperties("/Users/artur/IdeaProjects/tests_experiments_preparations_examples/src/main/resources/local-kafka.properties"));

        for (int i = 0; i < times; i++) {
            ProducerRecord<K, V> producerRecord = new ProducerRecord<>(topic, key, record);
            producer.send(producerRecord, (recordMetadata, e) -> {
                if (Objects.isNull(e)) {
                    logger.info(() -> "Message sent! Offset: " + recordMetadata.offset() + ", topic: " + recordMetadata.topic() + ", partition: " + recordMetadata.partition() + ", timestamp: " + recordMetadata.timestamp());
                } else {
                    logger.error(e::getMessage);
                }
            });
        }
        producer.flush();
    }

    private static OrderTenderDetailsEvents getTender(String orderNumber,
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

    private static OrderHeaderConsolidated getOrder(String orderNumber,
                                             String date,
                                             String transType) {
        return OrderHeaderConsolidated
                .newBuilder()
                .setOrderNumber(orderNumber)
                .setUsaId(666L)
                .setSephoraId(12345L)
                .setTransactionType(transType)
                .setOrderSubmitDate(date)
                .setChannelType("SEPHORA")
                .build();
    }


    public static void main(String[] args) {

        String time = "2022-06-03";

        List<OrderHeaderConsolidated> sales = new ArrayList<>();
        List<OrderHeaderConsolidated> returns = new ArrayList<>();
        List<OrderTenderDetailsEvents> tenders = new ArrayList<>();
        for (int i = 0; i <=25; i++) {
            String orderNum = Long.toString(new Date().getTime()+i);
            sales.add(getOrder(orderNum,time,"S"));
        //    if (i<=24) returns.add(getOrder(orderNum,time,"R"));
            tenders.add(getTender(orderNum,time,"S"));
        }

        assert (returns.size()==24);
        assert (sales.size()==25);

        sales.forEach(sale -> produceRecord(sale.getOrderNumber(),
                sale,
                "Sephora.DataPlatform.ReturnAuth.OrderHeaderConsolidated",1));

        returns.forEach(ret -> produceRecord(ret.getOrderNumber(),
                ret,
                "Sephora.DataPlatform.ReturnAuth.OrderHeaderConsolidated",1));

        tenders.forEach(ten -> produceRecord(ten.getOrderNumber(),
                ten,
                "Sephora.DataPlatform.ReturnAuth.OrderTenderDetailsEvents",1));

    }
}
