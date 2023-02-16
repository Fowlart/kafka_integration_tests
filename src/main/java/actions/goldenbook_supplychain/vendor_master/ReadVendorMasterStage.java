package actions.goldenbook_supplychain.vendor_master;

import kafka_utils.TopicReader;
public class ReadVendorMasterStage {
    private final static String topic = "Sephora.SupplyChain.Vendor";
    public static void main(String[] args) {
        TopicReader reader = new TopicReader();
        reader.readFromQaTopic(topic, 1, null);
    }
}
