package actions.goldenbook_supplychain.return_to_vendor;

import kafka_utils.TopicReader;

public class ReadReturnToVendorDev {
    private final static String topic = "Sephora.SupplyChain.RTV";

    public static void main(String[] args) {
        TopicReader reader = new TopicReader();
        reader.readFromDevTopic(topic, 1, null);
    }
}
