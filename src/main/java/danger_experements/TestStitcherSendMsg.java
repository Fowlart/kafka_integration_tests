package danger_experements;

import avro_pojos.OrderHeaderConsolidated;
import avro_pojos.OrderHeaderTender;
import avro_pojos.OrderTenderDetailsEvents;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestStitcherSendMsg {

    private static final MyKafkaProducer<Long, OrderHeaderTender> producerA =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForLocalProducer(LongSerializer.class));

    private static final MyKafkaProducer<String, OrderHeaderTender> producerB =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForProducerOnQaEnv(StringSerializer.class));

    private static OrderHeaderConsolidated getOrder(Long usaId, String orderNumber, String date, String dateTime, String transType) {
        return OrderHeaderConsolidated
                .newBuilder()
                .setOrderNumber(orderNumber)
                .setUsaId(usaId)
                .setSephoraId(12348L)
                .setTransactionType(transType)
                .setOrderSubmitDate(date)
                .setOrderSubmitDatetime(dateTime)
                .setChannelType("SEPHORA")
                .setIsDeclined(false)
                .setReturnReturnCounter(0)
                .setReturnSaleCounter(0)
                .build();
    }

    private static OrderTenderDetailsEvents getTender(String cardNumber, String orderNumber,
                                                      String date,
                                                      String transType) {

        return OrderTenderDetailsEvents
                .newBuilder()
                .setOrderNumber(orderNumber)
                .setCardNumber(cardNumber)
                .setTransactionType(transType)
                .setOrderSubmitDate(date)
                .build();
    }

    private static String getCurrentTimeStamp(String format) {
        SimpleDateFormat sdfDate = new SimpleDateFormat(format);
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    public static void main(String[] args) {

        String date = getCurrentTimeStamp("yyyy-MM-dd");
        String dateTime = getCurrentTimeStamp("yyyy-MM-dd HH:mm:ss");

        OrderHeaderConsolidated orderA = getOrder(   111L, "1234", date, dateTime, "S");
        OrderTenderDetailsEvents tenderA = getTender("CC1", "1234", date, "S");

        OrderHeaderConsolidated orderB = getOrder(   null, "1234", date, dateTime, "S");
        OrderTenderDetailsEvents tenderB = getTender("CC30", "1234", date, "S");

        OrderHeaderTender orderHeaderTenderA = OrderHeaderTender
                .newBuilder()
                .setOrderHeader(orderA)
                .setOrderTender(tenderA)
                .build();

        OrderHeaderTender orderHeaderTenderB = OrderHeaderTender
                .newBuilder()
                .setOrderHeader(orderB)
                .setOrderTender(tenderB)
                .build();


        for (long i = 1; i<=100;i++) {
            orderHeaderTenderA.getOrderHeader().setUsaId(i);
            orderHeaderTenderA.getOrderTender().setCardNumber("CC"+i);
            System.out.println("to UsaIdOrderHeaderTender: "+orderHeaderTenderA);
            producerA.produceRecord(i, orderHeaderTenderA, "Sephora.DataPlatform.ReturnAuth.UsaIdOrderHeaderTender", 1);
        }

        // System.out.println("to UsaIdOrderHeaderTender: "+orderHeaderTenderB);
        // producerB.produceRecord("CC30", orderHeaderTenderB, "Sephora.DataPlatform.ReturnAuth.CardNumberOrderHeaderTender", 1);
    }
}
