package actions.goldenbook_supplychain.pojos;

import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;

public class ReadAvroSchema {
    public static void main(String[] args) {
        VendorRecord record = new VendorRecord();
        Schema schema = ReflectData.get().getSchema(record.getClass());
        System.out.println(schema);
    }
}
