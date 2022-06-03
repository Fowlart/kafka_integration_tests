package test_cases;

import avro_pojos.OrderHeaderConsolidated;
import avro_pojos.OrderTenderDetailsEvents;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;
import org.apache.commons.compress.utils.Lists;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class ProduceDataAtInputTopics {

    private static final MyKafkaProducer<String, OrderHeaderConsolidated> orderHeaderConsolidatedMyKafkaProducer =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForLocalProducer());

    private static final MyKafkaProducer<String, OrderTenderDetailsEvents> orderTenderDetailsEventsMyKafkaProducer =
            new MyKafkaProducer<>(PropertiesUtil.getPropertiesForLocalProducer());

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

    private static OrderHeaderConsolidated getOrder(String orderNumber, String date, String transType) {
        return OrderHeaderConsolidated
                .newBuilder()
                .setOrderNumber(orderNumber)
                .setUsaId(669L)
                .setSephoraId(12348L)
                .setTransactionType(transType)
                .setOrderSubmitDate(date)
                .setChannelType("SEPHORA")
                .build();
    }


    public static void main(String[] args) {

        String time = "2022-06-03";

        List<OrderHeaderConsolidated> sales = Lists.newArrayList();
        List<OrderHeaderConsolidated> returns = Lists.newArrayList();
        List<OrderTenderDetailsEvents> tenders = Lists.newArrayList();

        IntStream.range(0,24).forEach(i -> {
            String orderNum = Long.toString(new Date().getTime() + i);
            sales.add(getOrder(orderNum, time, "S"));
            if (i<=23) returns.add(getOrder(orderNum,time,"R"));
            tenders.add(getTender(orderNum, time, "S"));
        });

        assert (returns.size() == 24);
        assert (sales.size() == 25);

        sales.forEach(sale -> orderHeaderConsolidatedMyKafkaProducer.produceRecord(sale.getOrderNumber(),
                sale,
                "Sephora.DataPlatform.ReturnAuth.OrderHeaderConsolidated", 1));

        returns.forEach(ret -> orderHeaderConsolidatedMyKafkaProducer.produceRecord(ret.getOrderNumber(),
                ret,
                "Sephora.DataPlatform.ReturnAuth.OrderHeaderConsolidated", 1));

        tenders.forEach(ten -> orderTenderDetailsEventsMyKafkaProducer.produceRecord(ten.getOrderNumber(),
                ten,
                "Sephora.DataPlatform.ReturnAuth.OrderTenderDetailsEvents", 1));
    }
}