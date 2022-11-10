package actions.goldenbook_supplychain.ASN_accuracy;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import actions.goldenbook_supplychain.pojos.UsrAsnAuditRecord;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;

import java.io.File;
import java.util.List;

public class UsrAsnAuditSendMessage {

    private static final MyKafkaProducer<String, String> producer = new MyKafkaProducer<>(PropertiesUtil.getPropertiesForProducerOnDevEnvForStringKeyAndValueWithoutSchema());

    private static final String TOPIC_NAME = "SupplyChain.WMS.asnAuditBIFeed";

    public static void main(String[] args) throws Exception {

        File csv = new File("src/main/resources/usr_asn_audit.csv");

        ObjectMapper objectMapper = new ObjectMapper();

        UsrAsnAuditRecord record = readFile(csv).get(3);

        record.audit_log_id = "special_id_347";

        record.asnflgcnt = 654;

        record.wh_id = "CHANGED";

        String json = objectMapper.writeValueAsString(record);

        System.out.println(record.audit_log_id);

        System.out.println(json);

        for (long i = 1; i <= 1; i++) producer.produceRecord(null, json, TOPIC_NAME, 1);
    }

    public static List<UsrAsnAuditRecord> readFile(File csvFile) throws Exception {
        MappingIterator<UsrAsnAuditRecord> iterator = new CsvMapper().readerWithTypedSchemaFor(UsrAsnAuditRecord.class).readValues(csvFile);
        return iterator.readAll();
    }
}
