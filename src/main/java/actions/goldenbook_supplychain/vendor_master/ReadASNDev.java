package actions.goldenbook_supplychain.vendor_master;

import kafka_utils.JsonTopicReader;

public class ReadASNDev {
    private final static String topic = "Sephora.SupplyChain.ASN";

    public static void main(String[] args) {
        JsonTopicReader reader = new JsonTopicReader();
        reader.readFromDevTopic(topic, 5, null);
    }
}
