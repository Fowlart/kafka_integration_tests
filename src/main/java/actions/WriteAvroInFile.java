package actions;

import avro_pojos.Account;
import com.google.common.collect.Lists;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;

import java.io.File;
import java.io.IOException;

public class WriteAvroInFile {

    public static void main(String[] args) throws IOException {

        Account account = Account.newBuilder()
                .setCardNumbers(Lists.newArrayList("1245", "5421", "6787"))
                .setGroupId("1232342")
                .setIsAnonymous(false)
                .setUsaId("234334434232")
                .setHistoricalGroupIds(Lists.newArrayList("1245", "5421", "6787"))
                .build();

        Schema accSchema = account.getSchema();

        GenericRecord accountG = new GenericData.Record(accSchema);
        accountG.put("card_numbers", Lists.newArrayList("1245", "5421", "6787"));
        accountG.put("group_id", "1232342");
        accountG.put("usa_id", "234334434232");
        accountG.put("is_anonymous", false);
        accountG.put("historical_group_ids", Lists.newArrayList("1245", "5421", "6787"));

        serialize(accSchema, accountG);
    }

    private static void serialize(final Schema schema, final GenericRecord... records) throws IOException {
        // Serialize users to disk
        final DatumWriter<GenericRecord> writer = new GenericDatumWriter<>(schema);
        try (DataFileWriter<GenericRecord> fileWriter = new DataFileWriter<>(writer)) {
            fileWriter.create(schema, new File("src/main/resources/avro-msg.avro"));
            for (GenericRecord user : records) {
                fileWriter.append(user);
            }
        }
    }

}
