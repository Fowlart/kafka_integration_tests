package preparation_2;

import java.util.Date;

public class ConstantUser {

    private  String name;

    private Date date;

    public ConstantUser(String name, Date date) {
     this.date = (Date)date.clone();
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }



    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        ConstantUser constantUser = new ConstantUser("art",date);
        date.setDate(100000);
        System.out.println(constantUser.getDate());


    }



}