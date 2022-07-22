package danger_experements;

import kafka_utils.PropertiesUtil;
import org.apache.avro.generic.GenericData;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.time.Duration;
import java.util.Collections;

public class TestStitcherConsumeMsg {

    private static final Logger logger = LoggerFactory.getLogger(TestStitcherConsumeMsg.class);

    public static void main(String[] args) {

        KafkaConsumer<String, GenericData.Record> consumer =
                new KafkaConsumer<>(PropertiesUtil.getPropertiesForQaConsumer("Sephora.DataPlatform.ReturnAuth.CustomerTransactionsLogger.GRP.STG","100290"));

        consumer.subscribe(Collections.singleton("Sephora.DataPlatform.ReturnAuth.OrderHeaderTenderConsolidated"));

        //poll for data
        while (true) {
            ConsumerRecords<String, GenericData.Record> consumerRecords = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, GenericData.Record> cr : consumerRecords) {
                logger.info(()->cr.value().toString());
            }
            //  consumer.commitSync();
        }
    }
}
