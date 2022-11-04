package danger_experements.reservation_details;

import kafka_utils.PropertiesUtil;
import org.apache.avro.generic.GenericData;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.time.Duration;
import java.util.Collections;

public class ReadAsnAudit {

    private static final Logger logger = LoggerFactory.getLogger(ReadAsnAudit.class);

    public static void main(String[] args) {

        KafkaConsumer<String, String> consumer =
                new KafkaConsumer<>(
                        PropertiesUtil
                                .getPropertiesForDevConsumer
                                        ("SupplyChain.WMS.asnAuditBIFeed.GRP.DEV",
                                                "100352"));


        consumer.subscribe(Collections.singleton("SupplyChain.WMS.asnAuditBIFeed"));

        //poll for data
        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> cr : consumerRecords) {
                logger.info(()->"KEY: "+cr.key() + " VALUE: " + cr.value());
            }
        }
    }

}
