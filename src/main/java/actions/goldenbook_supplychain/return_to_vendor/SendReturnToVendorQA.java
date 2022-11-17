package actions.goldenbook_supplychain.return_to_vendor;

import actions.goldenbook_supplychain.pojos.ReturnToVendorRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;

public class SendReturnToVendorQA {
    private static final MyKafkaProducer<String, String> producer =
            new MyKafkaProducer<>
                    (PropertiesUtil.getPropertiesForProducerOn_STAGE_EnvForStringKeyAndValueWithoutSchema());
    private static final String TOPIC_NAME = "Sephora.SupplyChain.RTV";

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ReturnToVendorRecord record = new ReturnToVendorRecord();
        record.RTV_Sku_Number = "1234";
        record.RTV_SKU_Unit_Cost = "12.5";
        record.Location_Number = "456";
        record.Corr_RTV_Loc = "Corr_RTV_Loc";
        record.VENDOR = "VENDOR";
        record.Vendor_Name = "Vendor_Name";
        record.RTV_Number = "1781"; // =ID=
        record.RA_Name = "RA_Name";
        record.RTV_Destination_Status = "RTV_Destination_Status";
        record.CVENDOR = "CVENDOR";
        record.ORIGINAL_SHIP_TO_VENDOR_DATE = "2022-11-16";
        record.Ship_To_Vdr_Date = "2022-11-16";
        record.Action_Date = "2022-11-16";
        record.Completion_Date = "2022-11-16";
        record.Non_PRTV_First_Drp_Timestamp = System.currentTimeMillis()/1000;
        record.PRTV_Drop_Timestamp = System.currentTimeMillis()/1000;
        record.RA_Number = "1257";
        record.Vendor_Approved_Amt = "Vendor_Approved_Amt";
        record.Currency_Code = "USD";
        record.RTV_create_Date = "2022-11-16";
        record.Vendor_Approved_Date = "2022-11-16";
        record.RTV_IC_APPROVED_DATE = "2022-11-16";
        record.RTV_IC_DENIED_DATE = "2022-11-16";
        record.RTV_SCHEDULE_APPROVED_DATE = "2022-11-16";
        record.RTV_CANCELLED_DATE = "2022-11-16";
        record.RTV_Open_units_PRTV = "10";
        record.RTV_Open_units_NON_PRTV = "10";
        record.RTV_Drop_units_PRTV = "10";
        record.RTV_Drop_units_NON_PRTV = "10";
        record.RTV_MCS_Shipped_Units_PRTV = "10";
        record.RTV_MCS_Shipped_Units_NON_PRTV = "10";
        record.RTV_MCS_DC_Acknowledged_units_PRT = "10";
        record.RTV_MCS_DC_Acknowledged_units_NON = "10";
        record.RTV_MCS_DC_Acknowledged_units = "10";
        record.RTV_Close_date = "2022-11-16";
        record.Final_RTV_Units = "10";
        record.Final_RTV_Ext_Cost = "12.5";
        record.RTV_Reason_Code = "UPDATED-35";
        record.RTV_Create_Type = "RTV_Create_Type";
        record.RTV_Cancel_by = "RTV_Cancel_by";
        record.Mixed_Load_Flag = "Mixed_Load_Flag";
        record.MIxed_Load_sku_amount = "10";
        String json = objectMapper.writeValueAsString(record);
        System.out.println(json);
        producer.produceRecord("1", json, TOPIC_NAME, 1);
    }
}
