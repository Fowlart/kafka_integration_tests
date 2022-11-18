package actions.goldenbook_supplychain.pojos;

import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;

import java.lang.reflect.Field;

public class AsnCanRecord {
    public Long po_number;
    public Long vendor_number;
    public String vendor_name;
    public Long department_number;
    public String po_ship_to_location;
    public Long brand_number;
    public String brand_description;
    public Long sku_number;
    public String sku_description;
    public Long upcean_number;
    public Long asn_carton_id;
    public Long asn_shipped_quantity;
    public String asn_received_date;
    public String expiration_date;
    public Long lot_number;

    public static void printAvroSchema(){
        Schema schema = ReflectData.get().getSchema(AsnCanRecord.class);
        System.out.println(schema.toString());
        System.out.println();
    }

    public static void printAllFields(){
        Class c = AsnCanRecord.class;
        Field[] fields = c.getFields();
        for(int i = 0; i < fields.length; i++) {
            System.out.println("record." + fields[i].getName()+";");
        }
        System.out.println();
    }

    public static void printAllFieldsAlt(){
        Class c = AsnCanRecord.class;
        Field[] fields = c.getFields();
        for(int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName()+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printAvroSchema();
        printAllFields();
        printAllFieldsAlt();
    }
}
