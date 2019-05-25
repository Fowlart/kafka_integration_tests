package preparation_1;

public class PassByValue {

    public static void main(String[] args) {
        int age = 2;
        changeAge(age);
        System.out.println("age inside main(): " +age);
    }

    public static void changeAge(int age) {
        age = age + 10;
        System.out.println("age inside changeAge(int age): " + age);
    }
}
