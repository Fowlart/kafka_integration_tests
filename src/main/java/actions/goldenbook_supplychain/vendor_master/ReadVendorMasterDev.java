package actions.goldenbook_supplychain.vendor_master;

import kafka_utils.JsonTopicReader;
public class ReadVendorMasterDev {
    private final static String topic = "Sephora.SupplyChain.Vendor";
    public static void main(String[] args) {
        JsonTopicReader reader = new JsonTopicReader();
        reader.readFromDevTopic(topic, 5, null);
    }
}
