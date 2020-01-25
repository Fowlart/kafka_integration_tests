package preparation_2;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.function.BiFunction;

public class IsMapCanContainFunction {
    public static void main(String[] args) {
        Map<Integer, BiFunction> map = Maps.newHashMap();

        BiFunction<Integer, Integer,Integer> adder =(x,y)-> x+y;
        BiFunction<Integer, Integer,Integer> divader = (x,y)-> x/y;
        map.put(1,adder);
        map.put(2,divader);
        int x =5;
        int y =2;
        map.values().stream().forEach((biFunction -> System.out.println(biFunction.apply(x,y))));
    }
}
