package stream_api;

import stream_api.entitys.Employe;
import stream_api.entitys.Gender;
import stream_api.entitys.Position;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

class Tuple implements Comparable<Tuple> {
    private int age;
    private Gender gender;

    @Override
    public String toString() {
        return "Tuple{" +
                "age=" + age +
                ", gender=" + gender +
                '}';
    }

    public Tuple(Employe employe) {
        this.age = employe.getAge();
        this.gender = employe.getGender();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple)) return false;
        Tuple tuple = (Tuple) o;
        return age == tuple.age &&
                gender == tuple.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, gender);
    }

    @Override
    public int compareTo(Tuple o) {
        double oGenderfactor = (o.gender == Gender.FEMALE) ? 0.8 : 1d;
        double thisGenderfactor = (gender == Gender.FEMALE) ? 0.8 : 1d;
        return (int) (o.age * oGenderfactor) - (int) (age * thisGenderfactor);
    }
}

public class GroupingByCollectors {
    public static void main(String[] args) {
        //1 - Simple scenario
        Map<Integer, List<Employe>> result1 = TestClass.getTestData().stream().collect(Collectors.groupingBy(Employe::getAge));
        System.out.println(result1.keySet());

        //2 - Grouping by with a Complex Map Key Type
        Map<Tuple, List<Employe>> result2 = TestClass.getTestData().stream().collect(Collectors.groupingBy(employe -> new Tuple(employe)));
        System.out.println(result2.keySet());

        //3 -The second overload of groupingBy takes an additional second collector (downstream collector), that is applied to the results of the first collector.
        Map<Integer, Set<Employe>> result3 = TestClass.getTestData().stream().collect(Collectors.groupingBy(Employe::getAge, Collectors.toSet()));
        System.out.println(result3.keySet());

        //4 - Grouping By Multiple Fields
        Map<Integer, Map<Position, List<Employe>>> result4 =
                TestClass.getTestData().stream().collect(Collectors.groupingBy(Employe::getAge, Collectors.groupingBy(Employe::getPosition)));

        //5 - Getting the Average from Grouped Results
        Map<Gender, Double> result5 = TestClass.getTestData().stream().collect(Collectors.groupingBy(Employe::getGender, Collectors.averagingInt(Employe::getAge)));
        System.out.println("Avg MALE age:" + result5.get(Gender.MALE));
        System.out.println("Avg FEMALE age:" + result5.get(Gender.FEMALE));



    }
}
