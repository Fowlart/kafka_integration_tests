package actions.reservation_details;

import kafka_utils.TopicReader;

public class ReadReservationTopic {
    public static final String topic = "Stores.StoreDigital.Reservations.Auditing";
    public static void main(String[] args) {
        TopicReader topicReader = new TopicReader();

        topicReader.readFromDevTopic(topic,
                3,
                "100336");
    }
}
