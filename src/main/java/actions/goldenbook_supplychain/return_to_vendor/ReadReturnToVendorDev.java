package actions.goldenbook_supplychain.return_to_vendor;

import kafka_utils.JsonTopicReader;

public class ReadReturnToVendorDev {
    private final static String topic = "Sephora.SupplyChain.RTV";

    public static void main(String[] args) {
        JsonTopicReader reader = new JsonTopicReader();
        reader.readFromDevTopic(topic, 1, null);
    }
}
