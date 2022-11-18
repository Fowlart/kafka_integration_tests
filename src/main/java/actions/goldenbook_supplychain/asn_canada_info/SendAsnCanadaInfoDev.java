package actions.goldenbook_supplychain.asn_canada_info;

import actions.goldenbook_supplychain.pojos.AsnCanRecord;
import actions.goldenbook_supplychain.pojos.ReturnToVendorRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;

public class SendAsnCanadaInfoDev {
    private static final MyKafkaProducer<String, String> producer = new MyKafkaProducer<>(PropertiesUtil.getPropertiesForProducerOn_DEV_EnvForStringKeyAndValueWithoutSchema());
    private static final String TOPIC_NAME = "Sephora.SupplyChain.ASN";

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        AsnCanRecord record = new AsnCanRecord();
        record.po_number = 10L;//ID
        record.asn_received_date = "2021-11-18";//ID
        record.vendor_name = "vendor_name_2";
        record.vendor_number = 26789L;
        record.department_number = 8999L;
        record.po_ship_to_location = "New-York";
        record.brand_number = 9811L;
        record.brand_description = "brand_description";
        record.sku_number = 354L;
        record.sku_description = "sku_description";
        record.upcean_number = 987L;
        record.asn_carton_id = 36667L;
        record.asn_shipped_quantity = 1500L;
        record.expiration_date = "2021-11-18";
        record.lot_number = 311L;
        String json = objectMapper.writeValueAsString(record);
        System.out.println(json);
        producer.produceRecord("1", json, TOPIC_NAME, 1);
    }
}
