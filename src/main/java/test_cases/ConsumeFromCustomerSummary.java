package test_cases;

import avro_pojos.CustomerTransactionsSummary;
import kafka_utils.PropertiesUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;

public class ConsumeFromCustomerSummary {

    private static final Logger logger = LoggerFactory.getLogger(ConsumeFromCustomerSummary.class);

    public static void main(String[] args) {

        KafkaConsumer<String, CustomerTransactionsSummary> consumer =
                new KafkaConsumer<>(PropertiesUtil.getPropertiesForLocalConsumer("test_group_10"));

        consumer.subscribe(Collections.singleton("Sephora.DataPlatform.ReturnAuth.CustomerSummary"));

        //poll for data
        while (true) {
            ConsumerRecords<String, CustomerTransactionsSummary> consumerRecords = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, CustomerTransactionsSummary> cr : consumerRecords) {
                logger.info("key: " + cr.key() + "| \n \n \n value: " + cr.value());
            }
    }

}
}
