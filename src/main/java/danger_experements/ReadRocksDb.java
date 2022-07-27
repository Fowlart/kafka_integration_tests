package danger_experements;

import avro_pojos.AccountGroup;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.rocksdb.RocksIterator;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class ReadRocksDb {

    public static void iterate() {

        //Open RocksDB. Specify the DB save destination for open (created directly under the project if the following is specified)
        try (RocksDB rocksDb = RocksDB.open("/Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_3/rocksdb/CardNumberGroupId-store")) {
            //Get all the data in RocksDB (API#newIterator)
            System.out.println("Get all entries");
            RocksIterator iterator = rocksDb.newIterator();
            iterator.seekToFirst();
            while (iterator.isValid()) {
                StringDeserializer stringDeserializer = new StringDeserializer();
                System.out.println("key: "+stringDeserializer.deserialize("",iterator.key()));
                System.out.println("value: "+stringDeserializer.deserialize("",iterator.value()));
                iterator.next();
            }

        } catch (RocksDBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getAccountGroupIdByCard(String key, String storePath) {
        //Open RocksDB. Specify the DB save destination for open (created directly under the project if the following is specified)
        try (RocksDB rocksDb = RocksDB
                .open(storePath)) {
            StringSerializer stringSerializer = new StringSerializer();
            byte[] res = rocksDb.get(stringSerializer.serialize("", key));
            StringDeserializer stringDeserializer = new StringDeserializer();
            System.out.println("RESULT: "+stringDeserializer.deserialize("",res));
        } catch (RocksDBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getAccountGroupById(String key, String storePath) throws IOException {
        //Open RocksDB. Specify the DB save destination for open (created directly under the project if the following is specified)
        try (RocksDB rocksDb = RocksDB.open(storePath)) {
            StringSerializer stringSerializer = new StringSerializer();
            byte[] res = rocksDb.get(stringSerializer.serialize("", key));
            if (Objects.nonNull(res)) {
                System.out.println("RESULT:");
            } else {
                System.out.println("RESULT: " + res);
            }
        } catch (RocksDBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        getAccountGroupIdByCard("CC332", "/Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_0/rocksdb/CardNumberGroupId-store");
        getAccountGroupIdByCard("CC332", "/Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_1/rocksdb/CardNumberGroupId-store");
        getAccountGroupIdByCard("CC332", "/Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_2/rocksdb/CardNumberGroupId-store");
        getAccountGroupIdByCard("CC332", "/Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_3/rocksdb/CardNumberGroupId-store");
        getAccountGroupIdByCard("CC332", "/Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_4/rocksdb/CardNumberGroupId-store");
        getAccountGroupIdByCard("CC332", "/Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_5/rocksdb/CardNumberGroupId-store");

        // /Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_2/rocksdb/AccountGroup-store
        getAccountGroupById("332", "/Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_0/rocksdb/AccountGroup-store");
        getAccountGroupById("332", "/Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_1/rocksdb/AccountGroup-store");
        getAccountGroupById("332", "/Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_2/rocksdb/AccountGroup-store");
        getAccountGroupById("332", "/Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_3/rocksdb/AccountGroup-store");
        getAccountGroupById("332", "/Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_4/rocksdb/AccountGroup-store");
        getAccountGroupById("332", "/Users/artur/IdeaProjects/dp-analytics-2.0/return-auth/deploy/apps/return-auth-stitcher/state/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/Sephora.DataPlatform.ReturnAuth.Stage02Stitcher.Local/0_5/rocksdb/AccountGroup-store");
    }
}
