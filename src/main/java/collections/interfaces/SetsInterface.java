package collections.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class SetsInterface
{
	public static void main(String[] args)
	{
		// 1 - create set from list
		List<Integer> list = new ArrayList<>();
		Random random = new Random(47);
		for (int i = 0; i <= 100; i++)
		{
			list.add(new Integer(random.nextInt(100)));
		}
		System.out.println("List of elements: " + list);
		Set<Integer> noDups = list.stream().collect(Collectors.toSet());
		System.out.println("SETs of elements: " + noDups);

		//2 - create set from list, but safe original order
		Collection<Integer> noDups1 = new LinkedHashSet<>(list);
		System.out.println("2 - create set from list, but safe original order: " + noDups1);

		// 3 - example:
		String text = "Suppose you want to know which words in the argument list occur only once and which occur more than " +
				"once, but you do not want any duplicates printed out repeatedly. This effect can be achieved by generating " +
				"two sets — one containing every word in the argument list and the other containing only the duplicates. " +
				"The words that occur only once are the set difference of these two sets, which we know how to compute. " +
				"ere's how the resulting program looks.";

		String result = text.replaceAll(",|\\.|— ", "").toLowerCase();
		System.out.println(result);
		String[] stringMas = result.split(" ");
		Set<String> uniques = new HashSet<>();
		Set<String> dups = new HashSet<>();
		for (String a : stringMas)
			if (!uniques.add(a))
				dups.add(a);
		uniques.removeAll(dups);

		System.out.println(uniques);
		System.out.println(dups);


	}
}