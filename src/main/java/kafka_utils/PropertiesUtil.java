package kafka_utils;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public class PropertiesUtil {
    private static final String LOCAL_KAFKA_PROPS_PATH = "src/main/resources/local-kafka.properties";
    private static final String DEV_KAFKA_PROPS_PATH = "src/main/resources/dev-kafka.properties";
    private static final String QA_KAFKA_PROPS_PATH = "src/main/resources/qa-kafka.properties";
    // prod-kafka.properties
    private static final String PROD_KAFKA_PROPS_PATH = "src/main/resources/prod-kafka.properties";

    private static Properties getPropertiesFromFile(String filePath) {
        final Properties propsFromFile = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get(filePath))) {
            propsFromFile.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return propsFromFile;
    }

    public static <T> Properties getPropertiesForLocalProducer(Class<T> keySerializer) {
        Properties propsFromFile = getPropertiesFromFile(LOCAL_KAFKA_PROPS_PATH);
        final Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, propsFromFile.getProperty("kafka.server"));
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, propsFromFile.getProperty("schema-registry.server"));
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        return props;
    }

    public static Properties getPropertiesForLocalConsumer(String groupId) {
        final Properties propsFromFile = getPropertiesFromFile(LOCAL_KAFKA_PROPS_PATH);
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, propsFromFile.getProperty("kafka.server"));
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, propsFromFile.getProperty("schema-registry.server"));
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        props.put("group.id", groupId);
        return props;
    }

    public static <T> Properties getPropertiesForProducerOnQaEnv(Class<T> tClass, String schemaId) {
        return getCommonPropertiesForProducers(QA_KAFKA_PROPS_PATH,tClass,schemaId);
    }

    public static Properties getPropertiesForProducerOn_DEV_EnvForStringKeyAndValueWithoutSchema(){
        Properties result = getCommonPropertiesForProducers(DEV_KAFKA_PROPS_PATH,String.class,"null");
        result.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        result.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return result;
    }

    public static Properties getPropertiesForProducerOn_STAGE_EnvForStringKeyAndValueWithoutSchema(){
        Properties result = getCommonPropertiesForProducers(QA_KAFKA_PROPS_PATH,String.class,"null");
        result.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        result.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return result;
    }


    public static <T> Properties getPropertiesForProducerOnDevEnv
            (Class<T> tClass,
             String schemaId) {
        return getCommonPropertiesForProducers(DEV_KAFKA_PROPS_PATH,tClass,schemaId);
    }

    private static <T> Properties getCommonPropertiesForProducers(String devKafkaPropsPath,
                                                                  Class<T> tClass,
                                                                  String schemaId) {

        final Properties propsFromFile = getPropertiesFromFile(devKafkaPropsPath);
        final Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, propsFromFile.getProperty("kafka.server"));
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.jaas.config", propsFromFile.getProperty("sasl.jaas.config"));
        props.put("sasl.mechanism", "PLAIN");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.RETRIES_CONFIG, 1);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, tClass);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, propsFromFile.getProperty("schema-registry.server"));
        props.put(AbstractKafkaSchemaSerDeConfig.AUTO_REGISTER_SCHEMAS, false);
        props.put(AbstractKafkaSchemaSerDeConfig.USE_SCHEMA_ID, schemaId);
        props.put(AbstractKafkaSchemaSerDeConfig.BASIC_AUTH_CREDENTIALS_SOURCE, "USER_INFO");
        props.put(AbstractKafkaSchemaSerDeConfig.USER_INFO_CONFIG, propsFromFile.getProperty("basic.auth.user.info"));
        return props;
    }

    public static Properties getPropertiesForQaConsumer(String groupId, String schemaId) {
        return getCommonPropertiesForConsumers(groupId, schemaId, QA_KAFKA_PROPS_PATH);
    }

    public static Properties getPropertiesForProdConsumer(String groupId, String schemaId) {
        return getCommonPropertiesForConsumers(groupId, schemaId, PROD_KAFKA_PROPS_PATH);
    }

    public static Properties getPropertiesForDevConsumer(String groupId, String schemaId) {
        return getCommonPropertiesForConsumers(groupId, schemaId, DEV_KAFKA_PROPS_PATH);
    }

    private static Properties getCommonPropertiesForConsumers(String groupId, String schemaId, String devKafkaPropsPath) {
        final Properties propsFromFile = getPropertiesFromFile(devKafkaPropsPath);
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, propsFromFile.getProperty("kafka.server"));
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.jaas.config", propsFromFile.getProperty("sasl.jaas.config"));
        props.put("sasl.mechanism", "PLAIN");
        props.put("group.id", groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); //todo: refactor
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, propsFromFile.getProperty("schema-registry.server"));
        props.put(AbstractKafkaSchemaSerDeConfig.BASIC_AUTH_CREDENTIALS_SOURCE, "USER_INFO");
        props.put(AbstractKafkaSchemaSerDeConfig.USER_INFO_CONFIG, propsFromFile.getProperty("basic.auth.user.info"));
        if (Objects.nonNull(schemaId)) props.put(AbstractKafkaSchemaSerDeConfig.USE_SCHEMA_ID, schemaId);
        return props;
    }
}
