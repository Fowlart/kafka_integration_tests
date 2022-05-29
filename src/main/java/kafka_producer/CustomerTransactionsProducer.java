package kafka_producer;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import reach_file_formats.avro.CustomerTransactions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

public class CustomerTransactionsProducer {

    private static final Logger logger = LoggerFactory.getLogger(CustomerTransactionsProducer.class);

    public static void main(String[] args) {

        final Properties propsFromFile = new Properties();

        try (InputStream input = new FileInputStream("/Users/artur/IdeaProjects/tests_experiments_preparations_examples/src/main/resources/local.properties")) {
            propsFromFile.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        final Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, propsFromFile.getProperty("kafka.server"));
        props.put("security.protocol", "SASL_SSL");
        props.put("sasl.jaas.config", propsFromFile.getProperty("sasl.jaas.config"));
        props.put("sasl.mechanism", "PLAIN");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.RETRIES_CONFIG, 1);
        props.put("group.id", "Sephora.DataPlatform.TRE.CustomerTransactionsLogger.GRP.DEV");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, propsFromFile.getProperty("schema-registry.server"));
        props.put(AbstractKafkaSchemaSerDeConfig.AUTO_REGISTER_SCHEMAS, false);
        props.put(AbstractKafkaSchemaSerDeConfig.USE_SCHEMA_ID, "100262");
        props.put(AbstractKafkaSchemaSerDeConfig.BASIC_AUTH_CREDENTIALS_SOURCE, "USER_INFO");
        props.put(AbstractKafkaSchemaSerDeConfig.USER_INFO_CONFIG, propsFromFile.getProperty("basic.auth.user.info"));

        KafkaProducer<String, CustomerTransactions> producer = new KafkaProducer<>(props);

        for (int i = 0; i <= 10; i++) {
            CustomerTransactions customerTransactions = CustomerTransactions.newBuilder().setCardNumber("223").setActiveFlag("A").setCreatedDate(new Date().getTime()).setStartDate(new Date().getTime()).setCustReturnCounter(24).setCustSaleCounter(25).setEndDate(new Date().getTime()).setOnlineAtgId("1234").setPctSaleToReturn(90).setReasonText("Test record").setReturnAuthFlag("D").setSephoraId(123456l).setRecordUpdateFlag("A").setReturnCaseId("2323242424").setReturnSurrogateKey("2323242424")
                    .build();
            ProducerRecord<String, CustomerTransactions> producerRecord = new ProducerRecord<>("Sephora.DataPlatform.TRE.CustomerTransactionsLogger", "second", customerTransactions);

            producer.send(producerRecord, (recordMetadata, e) -> {
                if (Objects.isNull(e)) {
                    logger.info(() ->
                            " offset: " + recordMetadata.offset() +
                                    " topic: " + recordMetadata.topic() +
                                    " partition: " + recordMetadata.partition() +
                                    " timestamp: " + recordMetadata.timestamp());
                } else {
                    logger.error(e::getMessage);
                }
            });
        }
        producer.flush();
    }
}
