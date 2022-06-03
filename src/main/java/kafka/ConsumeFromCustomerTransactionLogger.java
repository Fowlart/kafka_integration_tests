package kafka;

import avro_pojos.CustomerTransactionsSummary;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.time.Duration;
import java.util.Collections;

public class ConsumeFromCustomerTransactionLogger {

    private static final Logger logger = LoggerFactory.getLogger(ConsumeFromCustomerTransactionLogger.class);


    public static void main(String[] args) {


        KafkaConsumer<String, CustomerTransactionsSummary> consumer =
                new KafkaConsumer<>(PropertiesUtil.getPropertiesForLocalConsumer());

        consumer.subscribe(Collections.singleton("Sephora.DataPlatform.ReturnAuth.CustomerTransactionsLogger"));

        //poll for data
        while (true) {
            ConsumerRecords<String, CustomerTransactionsSummary> consumerRecords = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, CustomerTransactionsSummary> cr : consumerRecords) {
                logger.info(() -> "key: " + cr.key() + "| \n \n \n value: " + cr.value());
            }
        }
    }
}
