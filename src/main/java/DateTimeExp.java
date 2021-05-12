import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeExp {

    public static void main(String[] args) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm");
        DateFormat dateFormat3 = new SimpleDateFormat("mm");
        System.out.println(dateFormat1.format(date));
        System.out.println(dateFormat2.format(date));
        System.out.println(dateFormat3.format(date));

        Date d = new Date(System.currentTimeMillis() - (86400000*7));
        System.out.println(d);

    }

}
