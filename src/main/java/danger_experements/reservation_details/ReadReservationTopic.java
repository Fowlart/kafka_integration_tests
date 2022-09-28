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

public class ReadReservationTopic {

    private static final Logger logger = LoggerFactory.getLogger(ReadReservationTopic.class);

    public static void main(String[] args) {

        KafkaConsumer<String, GenericData.Record> consumer =
                new KafkaConsumer<>(
                        PropertiesUtil
                        .getPropertiesForDevConsumer
                                ("Stores.StoreDigital.Reservations.Detail.Auditing.DataPlatform.DEV",
                                        "100241"));


        consumer.subscribe(Collections.singleton("Stores.StoreDigital.Reservations.Auditing"));

        //poll for data
        while (true) {
            ConsumerRecords<String, GenericData.Record> consumerRecords = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, GenericData.Record> cr : consumerRecords) {
                logger.info(()->"KEY: "+cr.key() + " VALUE: " + cr.value().toString());
            }
        }
    }
}
