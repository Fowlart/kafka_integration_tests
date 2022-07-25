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
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForProducerOnQaEnv(LongSerializer.class));

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

        OrderHeaderConsolidated order = getOrder(   1L, "1234", date, dateTime, "S");
        OrderTenderDetailsEvents tender = getTender("CC667", "1234", date, "S");

        OrderHeaderTender orderHeaderTender = OrderHeaderTender
                .newBuilder()
                .setOrderHeader(order)
                .setOrderTender(tender)
                .build();

        System.out.println("to UsaIdOrderHeaderTender: "+orderHeaderTender);
        producerA.produceRecord(1L, orderHeaderTender, "Sephora.DataPlatform.ReturnAuth.UsaIdOrderHeaderTender", 1);

       // order.setUsaId(null);
       // System.out.println("to CardNumberOrderHeaderTender: "+orderHeaderTender);
       // producerB.produceRecord("CC667", orderHeaderTender, "Sephora.DataPlatform.ReturnAuth.CardNumberOrderHeaderTender", 1);
    }
}
