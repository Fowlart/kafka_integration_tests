package actions.goldenbook_supplychain.vendor_master;

import kafka_utils.TopicReader;
public class ReadVendorMasterDev {
    private final static String topic = "Sephora.SupplyChain.Vendor";
    public static void main(String[] args) {
        TopicReader reader = new TopicReader();
        reader.readFromDevTopic(topic, 5, null);
    }
}
