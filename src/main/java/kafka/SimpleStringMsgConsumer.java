package kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class SimpleStringMsgConsumer {

    private static final Logger logger = LoggerFactory.getLogger(SimpleStringMsgConsumer.class);

    private static Properties getProperties(String filePath) {

        final Properties propsFromFile = new Properties();

        try (InputStream input = new FileInputStream(filePath)) {
            propsFromFile.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, propsFromFile.getProperty("kafka.server"));
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.jaas.config", propsFromFile.getProperty("sasl.jaas.config"));
        props.put("sasl.mechanism", "PLAIN");
        props.put("group.id", propsFromFile.getProperty("group.id"));
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }

    public static void main(String[] args) {

        //create consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getProperties("/Users/artur/IdeaProjects/tests_experiments_preparations_examples/src/main/resources/local.properties"));

        //subscribe consumer
        consumer.subscribe(Collections.singleton("Stores.StoreDigital.RetailSaleTransactions"));

        //poll for data
        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> cr : consumerRecords) {
                logger.info("key: " + cr.key() + "| \n \n \n value: " + cr.value());
            }
        }
    }
}
