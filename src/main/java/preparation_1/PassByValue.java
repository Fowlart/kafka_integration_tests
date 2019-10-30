package preparation_1;

import java.util.Date;

public class PassByValue {

    public static void main(String[] args) {
        int age = 2;
        changeAge(age);
        System.out.println("age inside main(): " +age);
        Date date = new Date();
        System.out.println(date);
        changeDate(date);
        System.out.println(date);
    }

    public static void changeAge(int age) {
        age = age + 10;
        System.out.println("age inside changeAge(int age): " + age);
    }

    public static void changeDate(Date date){
        date.setDate(11111);
    }
}
