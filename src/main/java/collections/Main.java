package collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Animal
{

	public Animal(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public String name;
	public int age;

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (!(o instanceof Animal))
			return false;
		Animal animal = (Animal) o;
		return age == animal.age &&
				name.equals(animal.name);
	}

	@Override
	public int hashCode()
	{
		return 25555;
	}

	@Override
	public String toString()
	{
		return "Animal{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}

public class Main
{


	public static void main(String[] args)
	{
		Utils.writeLine(1);
		/** The uniqueness of TreeSet elements provides through Comparator only, "Equals" not used. */
		Comparator<Integer> comparator = (o1, o2) -> 0;
		Set<Integer> set = new TreeSet<>(comparator);
		set.add(1);
		set.add(2);
		set.add(1);
		System.out.println(set.iterator().next());
		System.out.println(set.size());

		/** If method hashCode() returns same number and HashSet is used, we just lose pluses of HashSet */
		Utils.writeLine(2);
		HashSet<Animal> set1 = new HashSet<>();
		Animal animal1 = new Animal("Dog", 2);
		Animal animal2 = new Animal("Cat", 3);
		set1.add(animal1);
		set1.add(animal2);
		System.out.println(set1.size());
		set1.stream().forEach(System.out::println);
	}
}
