package reach_file_formats;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class SequenceFileReader {

    public static void main(String[] args) {

        String inputFile = "generated_files/sequence_file";

        Configuration conf = new Configuration();
        try {

            Path seqFilePath = new Path(inputFile);

            SequenceFile.Reader reader = new SequenceFile.Reader(conf,
                    SequenceFile.Reader.file(seqFilePath));

            Text key = new Text();
            LongWritable val = new LongWritable();
            while (reader.next(key, val)) {
                System.out.println(key + " | " + val);
            }
            reader.close();
        } catch(IOException e) {
            System.out.println("ERROR: Could not load hadoop configuration");
            e.printStackTrace();
        }

    }
}
