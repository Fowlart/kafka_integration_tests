package collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class SetsMethods
{
	public static void main(String[] args)
	{

		Random random = new Random(47);
		Set<Integer> set1 = new LinkedHashSet<>();
		SortedSet<Integer> set2 = new TreeSet<>();

		for (int i = 0; i <= 100; i++)
		{
			set1.add(random.nextInt(100));
			set2.add(random.nextInt(100));
		}

		Utils.outPutCollection(set1, set2, "First collections:");
		/**SortedSet methods*/
		System.out.println("___SortedSet methods:___");
		System.out.println("set2.first(): " + set2.first());
		System.out.println("set2.headSet(10): " + set2.headSet(10));
		System.out.println("set2.tailSet(81): " + set2.tailSet(81));
		System.out.println("set2.subSet(0,10): " + set2.subSet(7, 15));

	}
}
