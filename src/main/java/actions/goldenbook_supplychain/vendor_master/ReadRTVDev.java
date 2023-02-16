package actions.goldenbook_supplychain.vendor_master;

import kafka_utils.TopicReader;

public class ReadRTVDev {
    private final static String topic = "Sephora.SupplyChain.RTV";

    public static void main(String[] args) {
        TopicReader reader = new TopicReader();
        reader.readFromDevTopic(topic, 5, null);
    }
}
