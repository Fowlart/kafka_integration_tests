package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class GenericMethods<T>
{
	// usage generic methods with class-level parameter
	void fromArrayToCollection(T[] mas, Collection<T> collection)
	{
		for (T o : mas)
		{
			collection.add(o); // compile-time error
		}
	}

	// usage generic methods with method-level parameter
	static <T> void fromArrayToCollectionStatic(T[] a, Collection<T> c)
	{
		for (T o : a)
		{
			c.add(o);
		}
	}

	public static void main(String[] args)
	{
		// 1
		String[] stringMas = { "bang", "beng", "bing" };
		Collection<String> strings = new LinkedList<>();
		System.out.println(strings);
		GenericMethods<String> genericMethods = new GenericMethods<>();
		genericMethods.fromArrayToCollection(stringMas, strings);

		// no need to create object, and parametrized it
		fromArrayToCollectionStatic(stringMas, strings);
		System.out.println(strings);

		//2
		Integer[] ia = new Integer[100];
		Float[] fa = new Float[100];
		Double[] na = new Double[100];
		Collection<Number> cn = new ArrayList<>();

		fromArrayToCollectionStatic(ia,cn);
		fromArrayToCollectionStatic(fa,cn);
		fromArrayToCollectionStatic(na,cn);

	}
}