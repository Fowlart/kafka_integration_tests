package kafka;

import avro_pojos.CustomerTransactionsSummary;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ConsumeFromCustomerTransactionLogger {

    private static final Logger logger = LoggerFactory.getLogger(ConsumeFromCustomerTransactionLogger.class);

    private static Properties getProperties(String filePath) {

        final Properties propsFromFile = new Properties();

        try (InputStream input = new FileInputStream(filePath)) {
            propsFromFile.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, propsFromFile.getProperty("kafka.server"));
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, propsFromFile.getProperty("schema-registry.server"));
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put("group.id", "test_group_0");

        return props;
    }

    public static void main(String[] args) {


        KafkaConsumer<String, CustomerTransactionsSummary> consumer = new KafkaConsumer<>(getProperties("/Users/artur/IdeaProjects/tests_experiments_preparations_examples/src/main/resources/local-kafka.properties"));


        consumer.subscribe(Collections.singleton("Sephora.DataPlatform.ReturnAuth.CustomerTransactionsLogger"));

        //poll for data
        while (true) {
            ConsumerRecords<String, CustomerTransactionsSummary> consumerRecords = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, CustomerTransactionsSummary> cr : consumerRecords) {
                logger.info(()->"key: " + cr.key() + "| \n \n \n value: " + cr.value());
            }
        }
    }
}
