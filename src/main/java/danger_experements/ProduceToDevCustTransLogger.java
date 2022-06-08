package danger_experements;

import avro_pojos.CustomerTransactions;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;
import org.apache.commons.compress.utils.Lists;

import java.util.Date;

public class ProduceToDevCustTransLogger {

    private static final MyKafkaProducer<String, CustomerTransactions> producer =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForProducerOnDevEnv());

    public static void main(String[] args) {

        CustomerTransactions customerTransactions = CustomerTransactions
                .newBuilder()
                .setCardNumber("2234")
                .setActiveFlag("A")
                .setCreatedDate(new Date().getTime())
                .setStartDate(new Date().getTime())
                .setCustReturnCounter(24)
                .setCustSaleCounter(25)
                .setEndDate(new Date().getTime()).setOnlineAtgId("1234")
                .setPctSaleToReturn(90)
                .setReasonText("Test record")
                .setReturnAuthFlag("D")
                .setSephoraId(123456l)
                .setRecordUpdateFlag("A")
                .setReturnReferenceNumber("2323242424")
                .setReturnSurrogateKey("2323242424")
                .setOrders(Lists.newArrayList())
                .setRules(Lists.newArrayList())
                .setUsaId(666L)
                .build();

        producer.produceRecord("test", customerTransactions, "Sephora.DataPlatform.ReturnAuth.CustomerTransactionsLogger", 1);
    }
}
