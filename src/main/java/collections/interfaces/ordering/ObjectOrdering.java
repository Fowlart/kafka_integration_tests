package collections.interfaces.ordering;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/** https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html */

public class ObjectOrdering
{

	/***
	 * If the List consists of String elements, it will be sorted into alphabetical order. If it consists of Date elements,
	 * it will be sorted into chronological order. How does this happen? String and Date both implement the Comparable
	 * interface. Comparable implementations provide a natural ordering for a class, which allows objects of that class to
	 * be sorted automatically. The following table summarizes some of the more important Java platform classes that
	 * implement Comparable.
	 ***/
	public static void showDateOrdering() throws InterruptedException
	{

		Date d1 = new Date(System.currentTimeMillis());
		Thread.sleep(1000);
		Date d2 = new Date(System.currentTimeMillis());
		Thread.sleep(1000);
		Date d3 = new Date(System.currentTimeMillis());

		Set<Date> dateSet = new TreeSet<>();
		dateSet.add(d1);
		dateSet.add(d2);
		dateSet.add(d3);

		System.out.println(dateSet);
	}

	public static void main(String[] args) throws InterruptedException
	{
		showDateOrdering();
	}
}
