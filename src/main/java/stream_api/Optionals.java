package stream_api;

import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
        Integer i = null;
        Optional<Integer> res =  Optional.ofNullable(i);
        System.out.println(res.isPresent());

         res =  Optional.of(i);
        System.out.println(res.isPresent());
    }
}
