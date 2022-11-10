package actions.goldenbook_supplychain.reservation_details;

import kafka_utils.PropertiesUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.time.Duration;
import java.util.Collections;

public class ReadReservationTopic {

    private static final Logger logger = LoggerFactory.getLogger(ReadReservationTopic.class);

    public static void main(String[] args) {

        KafkaConsumer<String, String> consumer =
                new KafkaConsumer<>(
                        PropertiesUtil
                        .getPropertiesForDevConsumer
                                ("Stores.StoreDigital.Reservations.Detail.Auditing.DataPlatform.DEV",
                                        "100241"));


        consumer.subscribe(Collections.singleton("Stores.StoreDigital.Reservations.Auditing"));

        //poll for data
        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> cr : consumerRecords) {
                logger.info(()->"KEY: "+cr.key() + " VALUE: " + cr.value());
            }
        }
    }
}
