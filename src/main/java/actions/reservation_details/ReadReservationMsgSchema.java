package actions.reservation_details;

import com.sephora.services.reservation.avro.audit.ReservationAuditAvro;
import com.sephora.services.reservation.avro.audit.ReservationAvro;

public class ReadReservationMsgSchema {

    public static void main(String[] args) {
        ReservationAuditAvro reservationAuditAvro = new ReservationAuditAvro();
        System.out.println(reservationAuditAvro.getSchema().toString());
    }
}
