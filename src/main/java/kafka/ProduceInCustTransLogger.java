package kafka;

import avro_pojos.CustomerTransactions;

import java.util.Date;

public class ProduceInCustTransLogger {

    private static final MyKafkaProducer<String, CustomerTransactions> producer = new MyKafkaProducer<>(PropertiesUtil.getPropertiesForProducerOnDevEnv());


    public static void main(String[] args) {

        CustomerTransactions customerTransactions = CustomerTransactions
                .newBuilder()
                .setCardNumber("223")
                .setActiveFlag("A")
                .setCreatedDate(new Date().getTime())
                .setStartDate(new Date().getTime())
                .setCustReturnCounter(24)
                .setCustSaleCounter(25)
                .setEndDate(new Date().getTime()).setOnlineAtgId("1234")
                .setPctSaleToReturn(90).setReasonText("Test record")
                .setReturnAuthFlag("D")
                .setSephoraId(123456l)
                .setRecordUpdateFlag("A")
                .setReturnReferenceNumber("2323242424")
                .setReturnSurrogateKey("2323242424")
                .build();

        producer.produceRecord("the fourth", customerTransactions, "Sephora.DataPlatform.ReturnAuth.CustomerTransactionsLogger", 1);
    }
}
