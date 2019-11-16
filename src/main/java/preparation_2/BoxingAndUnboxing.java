package preparation_2;

public class BoxingAndUnboxing {

    public static void main(String[] args) {
        Double a = new Double(7);
        Double b = new Double(10);

        // Can be compile because of autoboxing feature
        System.out.println(a*b);
    }
}
