package actions.gamification;

import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;
import kafka_utils.TopicReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class ReadFromGamificationTopic {

    public static final String topic = "Sephora.Loyalty.Gamification.User";
    private static final MyKafkaProducer<String, String> producer = new MyKafkaProducer<>(PropertiesUtil.getPropertiesForProducerOn_STAGE_EnvForStringKeyAndValueWithoutSchema());

    public static void main(String[] args) {
        TopicReader topicReader = new TopicReader();

        List<String> res = topicReader.readStringValueFromQaTopic(topic, 10, null);
        res.forEach(System.out::println);


        res.forEach(it -> {
            // parse res String as JSON
            JSONObject generalObject = new JSONObject(it);

            JSONArray data = generalObject.getJSONArray("data");

            JSONObject event = data.getJSONObject(0);

            JSONObject game = event.getJSONObject("game");

            if (!game.get("task").equals(JSONObject.NULL)) {
                JSONObject task = game.getJSONArray("task").getJSONObject(0);
                task.put("appeasementNote", "Hello, Raja!");
                System.out.println(generalObject);
                //todo: send this json to kafka
                producer.produceRecord(String.valueOf(System.currentTimeMillis()), generalObject.toString(), topic, 1);
            }
        });
    }
}