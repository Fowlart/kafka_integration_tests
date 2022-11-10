package actions.goldenbook_supplychain.vendor_master;

import kafka_utils.PropertiesUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.time.Duration;
import java.util.Collections;

public class ReadVendorMasterDev {

    private static final Logger logger = LoggerFactory.getLogger(ReadVendorMasterDev.class);
    private final static String topic = "Sephora.SupplyChain.Vendor";
    private final static String groupId = topic+"GRP.DEV";

    public static void main(String[] args) {

        KafkaConsumer<String, String> consumer =
                new KafkaConsumer<>(PropertiesUtil.getPropertiesForDevConsumer(groupId, null));

        consumer.subscribe(Collections.singleton(topic));

        //poll for data
        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> cr : consumerRecords) {
                logger.info(()->"KEY: "+cr.key() + " VALUE: " + cr.value());
            }
        }
    }
}
