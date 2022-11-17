package actions.goldenbook_supplychain.ASN_accuracy;

import kafka_utils.JsonTopicReader;
public class ReadAsnAudit {
    private static final String topic = "SupplyChain.WMS.asnAuditBIFeed";
    public static void main(String[] args) {
        JsonTopicReader jsonTopicReader = new JsonTopicReader();
        jsonTopicReader.readFromDevTopic(topic,
                3,
                null);
    }
}
