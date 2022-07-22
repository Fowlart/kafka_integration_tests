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

public class ConsumeFromReturnCustSumm {

    private static final Logger logger = LoggerFactory.getLogger(ConsumeFromReturnCustSumm.class);

    public static void main(String[] args) {

        KafkaConsumer<String, GenericData.Record> consumer =
                new KafkaConsumer<>(PropertiesUtil.getPropertiesForQaConsumer("Sephora.DataPlatform.ReturnAuth.CustomerTransactionsLogger.GRP.STG",null));

        consumer.subscribe(Collections.singleton("Sephora.DataPlatform.ReturnAuth.CustomerTransactionsLogger"));

        //poll for data
        while (true) {
            ConsumerRecords<String, GenericData.Record> consumerRecords = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, GenericData.Record> cr : consumerRecords) {
                int salesCounter = Integer.parseInt(cr.value().get("cust_sale_counter").toString());
                int returnCounter = Integer.parseInt(cr.value().get("cust_return_counter").toString());
                if (salesCounter + returnCounter > 20)
                    logger.info(() -> "serialized value size: " + cr.serializedValueSize() + "; orders number: " + salesCounter + returnCounter);
            }
            //  consumer.commitSync();
        }
    }
}
