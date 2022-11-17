package actions.goldenbook_supplychain.vendor_master;

import kafka_utils.JsonTopicReader;
public class ReadVendorMasterStage {
    private final static String topic = "Sephora.SupplyChain.Vendor";
    public static void main(String[] args) {
        JsonTopicReader reader = new JsonTopicReader();
        reader.readFromQaTopic(topic, 1, null);
    }
}
