package collections.interfaces;

import java.util.Comparator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;


public class SortedSetInterface
{
	public static void main(String[] args)
	{
		SortedSet<Integer> sortedSet = new TreeSet<>();
		Random random = new Random(47);
		while (sortedSet.size() <= 100)
		{
			sortedSet.add(random.nextInt(1000));
		}
		System.out.println("Sorted set: " + sortedSet);

		//1 Range view — allows arbitrary range operations on the sorted set
		int randomNumber = 500;
		System.out.println(sortedSet.contains(randomNumber));
		System.out.println("sortedSet.headSet: " + sortedSet.headSet(randomNumber));
		System.out.println("sortedSet.tailSet: " + sortedSet.tailSet(1001));

		// Endpoints
		System.out.println("sortedSet.first(): " + sortedSet.first());
		System.out.println("sortedSet.last(): " + sortedSet.last());

        Comparator comparator = sortedSet.comparator();
        System.out.println(comparator);


	}
}
