package actions.goldenbook_supplychain.pojos;

import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;

import java.lang.reflect.Field;

public class ReturnToVendorRecord {
    public String RTV_Sku_Number;
    public String RTV_SKU_Unit_Cost;
    public String Location_Number;
    public String Corr_RTV_Loc;
    public String VENDOR;
    public String Vendor_Name;
    public String RTV_Number;
    public String RA_Name;
    public String RTV_Destination_Status;
    public String CVENDOR;
    public String ORIGINAL_SHIP_TO_VENDOR_DATE;
    public String Ship_To_Vdr_Date;
    public String Action_Date;
    public String Completion_Date;
    public Long Non_PRTV_First_Drp_Timestamp;
    public Long PRTV_Drop_Timestamp;
    public String RA_Number;
    public String Vendor_Approved_Amt;
    public String Currency_Code;
    public String RTV_create_Date;
    public String Vendor_Approved_Date;
    public String RTV_IC_APPROVED_DATE;
    public String RTV_IC_DENIED_DATE;
    public String RTV_SCHEDULE_APPROVED_DATE;
    public String RTV_CANCELLED_DATE;
    public String RTV_Open_units_PRTV;
    public String RTV_Open_units_NON_PRTV;
    public String RTV_Drop_units_PRTV;
    public String RTV_Drop_units_NON_PRTV;
    public String RTV_MCS_Shipped_Units_PRTV;
    public String RTV_MCS_Shipped_Units_NON_PRTV;
    public String RTV_MCS_DC_Acknowledged_units_PRT;
    public String RTV_MCS_DC_Acknowledged_units_NON;
    public String RTV_MCS_DC_Acknowledged_units;
    public String RTV_Close_date;
    public String Final_RTV_Units;
    public String Final_RTV_Ext_Cost;
    public String RTV_Reason_Code;
    public String RTV_Create_Type;
    public String RTV_Cancel_by;
    public String Mixed_Load_Flag;
    public String MIxed_Load_sku_amount;

    public static void printAvroSchema(){
        Schema schema = ReflectData.get().getSchema(ReturnToVendorRecord.class);
        System.out.println(schema.toString());
    }

    public static void printAllFields(){
        Class c = ReturnToVendorRecord.class;
        Field[] fields = c.getFields();
        for(int i = 0; i < fields.length; i++) {
            System.out.println("record." + fields[i].getName()+";");
        }
    }

    public static void main(String[] args) {
        printAvroSchema();
        printAllFields();
    }
}
