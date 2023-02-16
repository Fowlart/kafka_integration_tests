package actions.reservation_details;

import com.sephora.services.reservation.avro.audit.ReservationAuditAvro;
import com.sephora.services.reservation.avro.audit.ReservationAvro;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;
import org.apache.kafka.common.serialization.LongSerializer;

public class ReservationSendMessage {

    private static final MyKafkaProducer<Long, ReservationAuditAvro> producer =
            new MyKafkaProducer<>(PropertiesUtil
                    .getPropertiesForProducerOnDevEnv(LongSerializer.class, "100369"));


    public static void main(String[] args) {

        ReservationAvro reservationAvro = ReservationAvro
                .newBuilder()
                .setReservationId("99999")
                .setChannelId("web")
                .setWorld("Makeup,Fragrance")
                .build();

        ReservationAuditAvro reservationAuditAvro = ReservationAuditAvro
                .newBuilder()
                .setReservation(reservationAvro)
                .setStatus("COMPLETED")
                .setUpdateTimestamp("2022-09-30T18:00:00")
                .setCreatedTimeStamp("2022-09-30T18:00:00")
                .setNetSalesUsdAmount("666")
                .setNetSalesLocalAmount("666")
                .build();

        System.out.println(reservationAuditAvro.toString());

        for (long i = 1; i <= 1; i++)
            producer.produceRecord(109992L, reservationAuditAvro, "Stores.StoreDigital.Reservations.Auditing", 1);

    }
}
