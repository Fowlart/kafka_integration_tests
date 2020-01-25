package preparation_2;

import java.math.BigDecimal;
import java.math.MathContext;

public class FloatingPoints {
    public static void main(String[] args) {
        double a = 0.1;
        double b = 0.2;
        System.out.println(a+b);
        double c = 0.3;
        System.out.println(c==a+b);

        BigDecimal f = new BigDecimal(0.1d);
        BigDecimal g = new BigDecimal(0.2d);
        System.out.println(f.add(g).round(new MathContext(3)));

    }
}
