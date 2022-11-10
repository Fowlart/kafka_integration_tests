package actions.goldenbook_supplychain.ASN_accuracy;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import actions.goldenbook_supplychain.pojos.SupmstRecord;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;

import java.io.File;
import java.util.List;

public class SupMstSendMessage {

    private static final MyKafkaProducer<String, String> producer = new MyKafkaProducer<>(PropertiesUtil.getPropertiesForProducerOnDevEnvForStringKeyAndValueWithoutSchema());
    private static final String TOPIC_NAME = "SupplyChain.WMS.supmstBIFeed";
    public static List<SupmstRecord> readFile(File csvFile) throws Exception {
        MappingIterator<SupmstRecord> iterator = new CsvMapper().readerWithTypedSchemaFor(SupmstRecord.class).readValues(csvFile);
        return iterator.readAll();
    }

    public static void main(String[] args) throws Exception {

        File csv = new File("src/main/resources/supmst_bi_feed.csv");

        ObjectMapper objectMapper = new ObjectMapper();

        SupmstRecord record = readFile(csv).get(3);

        System.out.println("Changing record with supnum ="+record.supnum);

        record.trust_flg = 999;

        String json = objectMapper.writeValueAsString(record);

        producer.produceRecord(null, json, TOPIC_NAME, 1);
    }
}
