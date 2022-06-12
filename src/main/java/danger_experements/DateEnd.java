package danger_experements;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateEnd {

    public static void main(String[] args) {
        Long endDate =
                LocalDateTime.of(9999, 12, 31, 0, 0)
                        .atZone(ZoneId.of("America/Los_Angeles")).toEpochSecond() * 1000;

        System.out.println(endDate);
    }
}
