package kafka_utils;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopicReader {

    private static final Logger logger = LoggerFactory.getLogger(TopicReader.class);

    private <K, V> void readTopic(KafkaConsumer<K, V> consumer, int msgNumber, String topicName) {
        int counter = 0;
        consumer.subscribe(Collections.singleton(topicName));
        while (counter <= msgNumber) {
            ConsumerRecords<K, V> consumerRecords = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<K, V> cr : consumerRecords) {
                counter++;
                logger.info(() -> "KEY: " + cr.key() + " VALUE: " + cr.value());
            }
        }
    }

    private <K, V> ArrayList<String> readValuesInListOfJsonStrings(KafkaConsumer<K, V> consumer, int msgNumber, String topicName) {
        int counter = 0;
        consumer.subscribe(Collections.singleton(topicName));
        ArrayList<String> strings = new ArrayList<>();
        while (counter <= msgNumber) {
            ConsumerRecords<K, V> consumerRecords = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<K, V> cr : consumerRecords) {
                counter++;
                if (counter > msgNumber) break;
                strings.add(cr.value().toString());
            }
        }
        return strings;
    }

    public void readFromDevTopic(String topicName, int msgNumber, String schemaId) {
        String groupId = topicName + ".GRP.DEV";
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(PropertiesUtil.getPropertiesForDevConsumer(groupId, schemaId));
        readTopic(consumer, msgNumber, topicName);
    }

    public void readFromQaTopic(String topicName, int msgNumber, String schemaId) {
        String groupId = topicName + ".GRP.STG";
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(PropertiesUtil.getPropertiesForQaConsumer(groupId, schemaId));
        readTopic(consumer, msgNumber, topicName);
    }

    public List<String> readStringValueFromQaTopic(String topicName, int msgNumber, String schemaId) {
        String groupId = topicName + ".GRP.STG"+System.currentTimeMillis()/1000;
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(PropertiesUtil.getPropertiesForQaConsumer(groupId, schemaId));
        return readValuesInListOfJsonStrings(consumer, msgNumber, topicName);
    }
}
