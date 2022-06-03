package test_cases;

import kafka_utils.PropertiesUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;

public class SimpleStringMsgConsumer {

    private static final Logger logger = LoggerFactory.getLogger(SimpleStringMsgConsumer.class);

    public static void main(String[] args) {

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(PropertiesUtil.getPropertiesForQaConsumer());
        consumer.subscribe(Collections.singleton("Stores.StoreDigital.RetailSaleTransactions"));
        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> cr : consumerRecords) {
                logger.info("key: " + cr.key() + "| \n \n \n value: " + cr.value());
            }
        }
    }
}
