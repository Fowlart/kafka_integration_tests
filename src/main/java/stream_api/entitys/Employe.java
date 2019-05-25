package stream_api.entitys;

import java.util.Objects;

public class Employe {

    private int age;
    private String name;
    private Gender gender;
    private Position position;
    private Seniority seniority;

    public Employe(int age, String name, Gender gender, Position position, Seniority seniority) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.position = position;
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", position=" + position +
                ", seniority=" + seniority +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Position getPosition() {
        return position;
    }

    public Seniority getSeniority() {
        return seniority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employe)) return false;
        Employe employe = (Employe) o;
        return age == employe.age &&
                Objects.equals(name, employe.name) &&
                gender == employe.gender &&
                position == employe.position &&
                seniority == employe.seniority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, gender, position, seniority);
    }
}
