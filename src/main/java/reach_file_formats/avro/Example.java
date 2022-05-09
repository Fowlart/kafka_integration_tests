package reach_file_formats.avro;

import com.google.common.collect.Lists;
import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.apache.avro.io.*;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.*;
import java.util.Date;

class AvroHttpRequestSchemaProvider {

    private static final Schema clientIdentifier = SchemaBuilder.record("ClientIdentifier").namespace("com.fowlart.avro").fields().requiredString("hostName").requiredString("ipAddress").endRecord();

    private static final Schema avroHttpRequest = SchemaBuilder.record("AvroHttpRequest").namespace("com.fowlart.avro").fields().requiredLong("requestTime").name("clientIdentifier").type(clientIdentifier).noDefault().name("employeeNames").type().array().items().stringType().arrayDefault(null).name("active").type().enumeration("Active").symbols("YES", "NO").noDefault().endRecord();

    public static Schema getClassSchema() {
        return avroHttpRequest;
    }
}

public class Example {

    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    public static void main(String[] args) {

        logger.info(()->"JSON avro representation:" + AvroHttpRequestSchemaProvider.getClassSchema().toString(true));

        Active active = Active.YES;
        ClientIdentifier clientIdentifier = ClientIdentifier
                .newBuilder()
                .setHostName("localHost")
                .setIpAddress("0.0.0.1")
                .build();

        AvroHttpRequest avroHttpRequest = AvroHttpRequest
                .newBuilder()
                .setActive(active)
                .setClientIdentifier(clientIdentifier)
                .setEmployeeNames(
                        Lists.newArrayList("Artur",
                                "Olena",
                                "Melani"))
                .setRequestTime(new Date().getTime())
                .build();

        logger.info(avroHttpRequest::toString);
        writeByte(serealizeAvroHttpRequestJSON(avroHttpRequest),"generated_files/object_1.json");
        String binaryFilePath = "generated_files/object_1.obj";
        writeByte(serealizeAvroHttpRequestBinary(avroHttpRequest),binaryFilePath);
        try {
           AvroHttpRequest result =  deSerealizeAvroHttpRequestBinary(readBytesFromFile(binaryFilePath));
            logger.info(()->"deserialized results: "+result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readBytesFromFile(String path) throws IOException
    {
        File file = new File(path);
        // Creating an object of FileInputStream to
        // read from a file
        FileInputStream fl = new FileInputStream(file);
        // Now creating byte array of same length as file
        byte[] arr = new byte[(int)file.length()];
        // Reading file content to byte array
        // using standard read() method
        fl.read(arr);
        // lastly closing an instance of file input stream
        // to avoid memory leakage
        fl.close();
        // Returning above byte array
        return arr;
    }

   static public void writeByte(byte[] bytes, String filePath)
    {
        // Try block to check for exceptions
        try {
            File file = new File(filePath);
            // Initialize a pointer in file
            // using OutputStream
            OutputStream os = new FileOutputStream(file);
            // Starting writing the bytes in it
            os.write(bytes);
            // Display message onconsole for successful
            // execution
            logger.info(()->"Successfully byte inserted");
            // Close the file connections
            os.close();
        }
        // Catch block to handle the exceptions
        catch (Exception e) {
            // Display exception on console
            logger.warn(()->"Exception: " + e);
        }
    }


   static public byte[] serealizeAvroHttpRequestJSON(AvroHttpRequest request) {

        DatumWriter<AvroHttpRequest> writer = new SpecificDatumWriter<>(AvroHttpRequest.class);
        byte[] data = new byte[0];
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Encoder jsonEncoder = null;
        try {
            jsonEncoder = EncoderFactory.get().jsonEncoder(AvroHttpRequestSchemaProvider.getClassSchema(), stream);
            writer.write(request, jsonEncoder);
            jsonEncoder.flush();
            data = stream.toByteArray();
        } catch (IOException e) {
            logger.error(() -> "Serialization error:" + e.getMessage());
        }
        return data;
    }

    static public byte[] serealizeAvroHttpRequestBinary(AvroHttpRequest request) {

        DatumWriter<AvroHttpRequest> writer = new SpecificDatumWriter<>(AvroHttpRequest.class);
        byte[] data = new byte[0];
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Encoder byteEncoder = null;
        try {
            byteEncoder = EncoderFactory.get().blockingBinaryEncoder(stream, null);
            writer.write(request, byteEncoder);
            byteEncoder.flush();
            data = stream.toByteArray();
        } catch (IOException e) {
            logger.error(() -> "Serialization error:" + e.getMessage());
        }
        return data;
    }

    static public AvroHttpRequest deSerealizeAvroHttpRequestBinary(byte[] data) throws IOException {
        DatumReader<AvroHttpRequest> reader = new SpecificDatumReader<>(AvroHttpRequest.class);
        Decoder decoder = DecoderFactory.get().binaryDecoder(data,null);;
        return reader.read(null, decoder);
    }
}