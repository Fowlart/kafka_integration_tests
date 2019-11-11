package groovy.primitives;

public class Casting {

    public static Object returnObj() {
        return 7.2;
    }

    public static void main(String[] args) {
        double myInt = (double) returnObj();
        System.out.println(myInt++);
    }
}
