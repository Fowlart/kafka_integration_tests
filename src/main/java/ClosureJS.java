import java.util.function.Function;

public class ClosureJS {

    public static Function makeFunc() {
        String msg = "I love you!";

        Function<Integer, Integer> function = (Integer x) -> {
            System.out.println(msg);
            return x * 2;
        };

        return function;
    }

    public static Function makeFunc2(){

        return new Function<Integer, Integer>() {

            String msg = "I love you!";

            @Override
            public Integer apply(Integer o) {
                System.out.println(msg);
                return o*2;
            }
        };
    }

    public static void main(String[] args) {
        makeFunc().apply(2);
        makeFunc2().apply(2);
    }
}
