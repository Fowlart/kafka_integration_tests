package danger_experements.reservation_details;

import com.sephora.services.reservation.avro.audit.ReservationAuditAvro;
import com.sephora.services.reservation.avro.audit.ReservationAvro;
import kafka_utils.MyKafkaProducer;
import kafka_utils.PropertiesUtil;
import org.apache.kafka.common.serialization.LongSerializer;

public class ReservationSendMessage {

    private static final MyKafkaProducer<Long, ReservationAuditAvro> producer = new MyKafkaProducer<>(PropertiesUtil
            .getPropertiesForProducerOnQaEnv(LongSerializer.class));


    public static void main(String[] args) {

        ReservationAvro reservationAvro = ReservationAvro.newBuilder()
                .setReservationId("666")
                .setChannelId("web")
                .setWorld("Makeup, Fragrance")
                .build();

        ReservationAuditAvro reservationAuditAvro = ReservationAuditAvro
                .newBuilder()
                .setReservation(reservationAvro)
                .setStatus("COMPLETED")
                .setUpdateTimestamp("2022-09-27T18:01:43")
                .setCreatedTimeStamp("2022-09-27T17:01:43")
                .build();

        System.out.println(reservationAuditAvro.toString());

        for (long i = 1; i <= 1; i++) producer.produceRecord(i, reservationAuditAvro, "Stores.StoreDigital.Reservations.Auditing", 1);

    }
}
