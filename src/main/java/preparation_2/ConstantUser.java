package preparation_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConstantUser {

    private final String name;

    private Date date;

    public ConstantUser(String name, String date) {
        SimpleDateFormat formatter2=new SimpleDateFormat("dd-MMM-yyyy");
        this.name = name;

        try {
            this.date = formatter2.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("Прикрутіть валідацію!!!!!!!!!");
        }
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}