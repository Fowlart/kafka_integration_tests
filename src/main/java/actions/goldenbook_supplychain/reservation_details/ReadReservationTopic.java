package actions.goldenbook_supplychain.reservation_details;

import kafka_utils.JsonTopicReader;

public class ReadReservationTopic {
    public static final String topic = "Stores.StoreDigital.Reservations.Auditing";
    public static void main(String[] args) {
        JsonTopicReader jsonTopicReader = new JsonTopicReader();
        jsonTopicReader.readFromQaTopic(topic,
                10,
                "100241");
    }
}
