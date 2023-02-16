package actions.telegram_bot;

import kafka_utils.TopicReader;

public class ReadTestMessageFromDpAnalytic {
    private final static String topic = "Sephora.DataPlatform.GoldenBook.VendorMaster";

    public static void main(String[] args) {
        TopicReader reader = new TopicReader();
        reader.readFromDevTopic(topic, 100, null);
    }
}
