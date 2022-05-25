import java.util.Calendar;
import java.util.Date;

public class KafkaIdMaxNumber {
    public static void main(String[] args) {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.YEAR, 20);
        Date modifiedDate = cal.getTime();

        long nanos = modifiedDate.getTime()-today.getTime();
        System.out.println("Amount of nanoseconds from now plus 20 years: "+nanos);
        int maxValOfTheOffset = String.valueOf(nanos).length();
        int maxValueOfTimestamp = String.valueOf(modifiedDate.getTime()).length();
        System.out.println("maxValOfTheOffset:"+maxValOfTheOffset);
        System.out.println("maxValueOfTimestamp:"+maxValueOfTimestamp);
        System.out.println(maxValOfTheOffset + maxValueOfTimestamp + 1);

        System.out.println(String.format("%05d", 1212L));
    }
}
