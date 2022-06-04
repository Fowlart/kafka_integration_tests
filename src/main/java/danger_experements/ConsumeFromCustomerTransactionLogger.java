package danger_experements;

import avro_pojos.CustomerTransactions;
import kafka_utils.PropertiesUtil;
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


        KafkaConsumer<String, CustomerTransactions> consumer =
                new KafkaConsumer<>(PropertiesUtil.getPropertiesForQaConsumer("Sephora.DataPlatform.ReturnAuth.CustomerTransactionsLogger.GRP.STG",null));

        consumer.subscribe(Collections.singleton("Sephora.DataPlatform.ReturnAuth.CustomerTransactionsLogger"));

        //poll for data
        while (true) {
            ConsumerRecords<String, CustomerTransactions> consumerRecords = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, CustomerTransactions> cr : consumerRecords) {
                logger.info(() -> "key: " + cr.key() + "| \n \n \n value: " + cr.value());
            }
            consumer.commitSync();
        }
    }
}
