package kafka_utils;

import test_cases.ProduceInCustTransLogger;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Objects;
import java.util.Properties;

public class MyKafkaProducer<K,V> {

    private org.apache.kafka.clients.producer.KafkaProducer<K,V> producer;

    public MyKafkaProducer(Properties properties) {
        this.producer = new org.apache.kafka.clients.producer.KafkaProducer<>(properties);
    }

    private static final Logger logger = LoggerFactory.getLogger(ProduceInCustTransLogger.class);

    public void produceRecord(K key, V record, String topic, int times) {
        for (int i = 0; i < times; i++) {
            ProducerRecord<K, V> producerRecord = new ProducerRecord<>(topic, key, record);
            producer.send(producerRecord, (recordMetadata, e) -> {
                if (Objects.isNull(e)) {
                    logger.info(() -> "Message sent! Offset: " + recordMetadata.offset() + ", topic: " + recordMetadata.topic() + ", partition: " + recordMetadata.partition() + ", timestamp: " + recordMetadata.timestamp());
                } else {
                    logger.error(e::getMessage);
                }
            });
        }
        producer.flush();
    }

}
