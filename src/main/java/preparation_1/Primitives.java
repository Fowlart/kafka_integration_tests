package preparation_1;

public class Primitives {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        System.out.println(a == b);
        /** Виходить, створюючи посилання через тип-обгортку, ці два типи вже будуть мати різну адрессу в памяті,
         * а отже "==" вертає false */
        Integer a1 = new Integer(5);
        Integer b1 = new Integer(5);
        System.out.println(a1 == b1);
        System.out.println(a1.equals(b1));
    }
}