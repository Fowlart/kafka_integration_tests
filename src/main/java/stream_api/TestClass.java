package stream_api;

import stream_api.entitys.Employe;
import stream_api.entitys.Gender;
import stream_api.entitys.Position;
import stream_api.entitys.Seniority;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TestClass {

    public static List<Employe> getTestData() {
        List<Employe> result = new ArrayList<>();
        result.add(new Employe(31, "Artur", Gender.MALE, Position.DEVELOPER, Seniority.JUNIOR));
        result.add(new Employe(31, "Olena", Gender.FEMALE, Position.BA, Seniority.MIDDLE));
        result.add(new Employe(60, "Zenoviy", Gender.MALE, Position.PM, Seniority.LEED));
        result.add(new Employe(31, "Viktoria", Gender.FEMALE, Position.BA, Seniority.SENIOR));
        result.add(new Employe(1, "Melania", Gender.FEMALE, Position.DEVELOPER, Seniority.JUNIOR));
        result.add(new Employe(50, "Angela", Gender.FEMALE, Position.DEVELOPER, Seniority.MIDDLE));
        result.add(new Employe(47, "Cosimo", Gender.MALE, Position.TESTER, Seniority.SENIOR));
        result.add(new Employe(31, "Taras", Gender.MALE, Position.DEVELOPER, Seniority.JUNIOR));
        result.add(new Employe(16, "Djovani", Gender.MALE, Position.TESTER, Seniority.MIDDLE));
        result.add(new Employe(60, "Cherry", Gender.FEMALE, Position.DEVELOPER, Seniority.SENIOR));
        return result;
    }

    public static List<Employe> getTestDataWithNull() {
        List<Employe> result = new ArrayList<>();
        result.add(new Employe(31, null, Gender.MALE, Position.DEVELOPER, Seniority.JUNIOR));
        return result;
    }

    public static List<Employe> getNull() {
        return null;
    }

    public static void main(String[] args) {

        // Just grouping by Position
        // static <T,K> Collector<T,?,Map<K,List<T>>> groupingBy(Function<? super T,? extends K> classifier)
        Map<Position, List<Employe>> result_1 = getTestData().stream().collect(groupingBy(Employe::getPosition));
        System.out.println(">>>case1: " + result_1.get(Position.DEVELOPER));

        // grouping by Position and reducing to min age
        // static <T,K,A,D> Collector<T,?,Map<K,D>> groupingBy(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream)
        Map<Position, Optional<Employe>> result_2 = getTestData().stream().
                collect(groupingBy(Employe::getPosition, minBy(Comparator.comparingInt(Employe::getAge))));
        System.out.println(">>>case2: " + result_2.get(Position.DEVELOPER));

        // return to begin point with flatMap using
        result_1.values().stream().flatMap(Collection::stream).collect(toList()).forEach(System.out::println);

        // converting list of result into single string
        Map<Position, String> result_3 = getTestData().stream().collect(groupingBy(Employe::getPosition, mapping
                (empl -> empl.getName(), joining(", ", " [", "]"))));
        System.out.println(result_3);

        // magically converting all test POJOs into single string with names of male.
        System.out.println(
                getTestData().stream().
                        collect(Collectors.partitioningBy((employe -> employe.getGender() == Gender.MALE))).
                        get(true).stream().map(Employe::getName).collect(Collectors.joining(", "))
        );

      Optional<String> nameOptional = getTestDataWithNull().stream().map(Employe::getName).filter(Objects::nonNull).findFirst();
      System.out.println(">>>>>"+nameOptional.get());

  //      System.out.println(getNull().stream().filter(Objects::nonNull).findAny().orElseGet(()->new Employe(12, "bob", Gender.FEMALE, Position.DEVELOPER, Seniority.JUNIOR)));

    }
}
