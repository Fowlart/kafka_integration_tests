package actions.goldenbook_supplychain.ASN_accuracy;

import kafka_utils.TopicReader;
public class ReadAsnAudit {
    private static final String topic = "SupplyChain.WMS.asnAuditBIFeed";
    public static void main(String[] args) {
        TopicReader topicReader = new TopicReader();
        topicReader.readFromDevTopic(topic,
                3,
                null);
    }
}
