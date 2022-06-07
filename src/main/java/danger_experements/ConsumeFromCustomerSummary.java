package danger_experements;

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

        KafkaConsumer<String, org.apache.avro.generic.GenericData.Record> consumer =
                new KafkaConsumer<>(PropertiesUtil.getPropertiesForQaConsumer("DataPlatformCreditCardDPPreScreen",
                        "100264"));

        consumer.subscribe(Collections.singleton("Sephora.DataPlatform.ReturnAuth.CustomerSummary"));

        //poll for data
        while (true) {
            ConsumerRecords<String, org.apache.avro.generic.GenericData.Record> consumerRecords = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, org.apache.avro.generic.GenericData.Record> cr : consumerRecords) {
                logger.info(cr+"\n \n \n");
            }
    }

}
}
