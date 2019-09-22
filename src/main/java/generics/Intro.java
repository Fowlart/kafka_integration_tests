package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class Intro
{
	private static void printCollection(Collection<?> c)
	{
	    StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n"+"[ ");
	    for (Object e : c)
		{
			stringBuilder.append(e+", ");
		}
        stringBuilder.append(" ]"+"\n");
	    System.out.print(stringBuilder.toString().replaceAll(",  ]"," ]"));
	}

	public static void main(String[] args)
	{
		/***
		 * In general, if Foo is a subtype (subclass or subinterface) of Bar, and G is some generic type declaration, it is not
		 * the case that G<Foo> is a subtype of G<Bar>. This is probably the hardest thing you need to learn about generics,
		 * because it goes against our deeply held intuitions.
		 ***/

		// Is the following code snippet legal? This boils down to the question: is a List of String a List of Object. Most people instinctively answer, "Sure!"
		// But NO!
		List<String> ls = new ArrayList<String>();
		// will produce compiler error
		// List<Object> lo = ls;

		List<Integer> list = new LinkedList<>();
		Set<Double> set = new LinkedHashSet<>();

		Random rand = new Random(47);

		for (int i = 0; i <= 100; i++)
		{
			list.add(rand.nextInt(1000));
			set.add(rand.nextDouble());
		}

		printCollection(list);
        printCollection(set);
	}
}
