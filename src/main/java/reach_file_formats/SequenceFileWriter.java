package reach_file_formats;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.io.IOException;

public class SequenceFileWriter {

    private static final Logger LOG = LoggerFactory.getLogger(SequenceFileWriter.class);

    public static void main(String[] args) {

        String outputFile = "generated_files/sequence_file.seq";

        Configuration conf = new Configuration();
        try {
            FileSystem fs = FileSystem.get(conf);

            Path seqFilePath = new Path(outputFile);
            fs.mkdirs(seqFilePath.getParent());

            SequenceFile.Writer writer = SequenceFile.createWriter(conf,
                    SequenceFile.Writer.file(seqFilePath), SequenceFile.Writer.keyClass(Text.class),
                    SequenceFile.Writer.valueClass(LongWritable.class));
            writer.append(new Text("Artur"), new LongWritable(2800L));
            writer.append(new Text("Olena"), new LongWritable(1200L));
            writer.append(new Text("Zenoviy"), new LongWritable(3500L));
            writer.close();

            LOG.info(() -> "SUCCESS: Successfully wrote " + seqFilePath + " to HDFS.");
        } catch (IOException e) {
            LOG.error(() -> "ERROR: Could not load hadoop configuration");
            e.printStackTrace();
        }
    }
}
