package danger_experements;

import avro_pojos.CustomerTransactions;
import avro_pojos.OrderHeaderConsolidated;
import avro_pojos.OrderHeaderTender;
import avro_pojos.OrderTenderDetailsEvents;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;
import org.apache.commons.compress.utils.Lists;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProduceToDevCustTransLogger {

    private static final MyKafkaProducer<String, CustomerTransactions> producer =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForProducerOnQaEnv());

    private static OrderHeaderConsolidated getOrder(String orderNumber, String date, String dateTime, String transType) {
        return OrderHeaderConsolidated
                .newBuilder()
                .setOrderNumber(orderNumber)
                .setUsaId(123L)
                .setSephoraId(12348L)
                .setTransactionType(transType)
                .setOrderSubmitDate(date)
                .setOrderSubmitDatetime(dateTime)
                .setChannelType("SEPHORA")
                .setIsDeclined(true)
                .build();
    }

    private static OrderTenderDetailsEvents getTender(String orderNumber,
                                               String date,
                                               String transType) {

        return OrderTenderDetailsEvents
                .newBuilder()
                .setOrderNumber(orderNumber)
                .setCardNumber("333")
                .setTransactionType(transType)
                .setOrderSubmitDate(date)
                .setOrderSubmitDatetimeLocal(date)
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

        OrderHeaderConsolidated order = getOrder("1234", date, dateTime, "S");
        OrderTenderDetailsEvents tender = getTender("1234", date, "S");

        OrderHeaderTender orderHeaderTender = OrderHeaderTender
                .newBuilder()
                .setOrderHeader(order)
                .setOrderTender(tender)
                .build();

        List<OrderHeaderTender> orderHeaderTenderList = Lists.newArrayList();

        orderHeaderTenderList.add(orderHeaderTender);

        CustomerTransactions customerTransactions = CustomerTransactions
                .newBuilder()
                .setCardNumber("2234")
                .setActiveFlag("A")
                .setCreatedDate(new Date().getTime())
                .setStartDate(new Date().getTime())
                .setCustReturnCounter(24)
                .setCustSaleCounter(25)
                .setEndDate(new Date().getTime())
                .setOnlineAtgId("1234")
                .setPctSaleToReturn(90)
                .setReasonText("Test record")
                .setReturnAuthFlag("D")
                .setSephoraId(123456l)
                .setRecordUpdateFlag("A")
                .setReturnReferenceNumber("2323242424")
                .setReturnSurrogateKey("2323242424")
                .setOrders(orderHeaderTenderList)
                .setRules(Lists.newArrayList())
                .setUsaId(666L)
                .build();

        producer.produceRecord("test_2", customerTransactions, "Sephora.DataPlatform.ReturnAuth.CustomerTransactionsLogger", 1);
    }
}
