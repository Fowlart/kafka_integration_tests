package collections.interfaces;

import collections.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class SetsInterface
{

	public static final int BOUND = 10000000;

	public static void main(String[] args)
	{
		//	setFromList();
		//	uniqueWords();
		//	sortedSetsMethods();

		/** HashSets vs LinkedList in add method */
		//	testHashSetAdd();
		//	testTreeSetAdd();
		//	testLinkedListAdd();

		setVsListContains();

	}

	private static void setVsListContains()
	{
		Random random = new Random(47);
		List<Integer> list = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i <= 10000000; i++)
		{
			list.add(random.nextInt(10000000));
		}

		while (set.size() < (list.size() - 500))
			set.add(random.nextInt(10000000));

		System.out.println(list.size());
		System.out.println(set.size());

		Integer maxVal = Integer.MAX_VALUE;

		long timer = System.currentTimeMillis();
		list.contains(maxVal);
		timer = System.currentTimeMillis() - timer;
		System.out.println(">>> time for list.contains " + timer);

		timer = System.currentTimeMillis();
		set.contains(maxVal);
		timer = System.currentTimeMillis() - timer;
		System.out.println(">>> time for set.contains " + timer);

		timer = System.currentTimeMillis();

		list.remove(maxVal);
		timer = System.currentTimeMillis() - timer;
		System.out.println(">>> list.remove " + timer);

		timer = System.currentTimeMillis();
		set.remove(maxVal);
		timer = System.currentTimeMillis() - timer;
		System.out.println(">>> set.remove " + timer);

	}

	private static void uniqueWords()
	{
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

	private static void sortedSetsMethods()
	{
		/** SortedSet methods */
		Set<Integer> set1 = new LinkedHashSet<>();
		SortedSet<Integer> set2 = new TreeSet<>();
		Random random = new Random(47);

		for (int i = 0; i <= 100; i++)
		{
			set1.add(random.nextInt(BOUND));
			set2.add(random.nextInt(BOUND));
		}

		Utils.outPutCollection(set1, set2, "First collections:");

		System.out.println("___SortedSet methods:___");
		System.out.println("set2.first(): " + set2.first());
		System.out.println("set2.headSet(10): " + set2.headSet(10));
		System.out.println("set2.tailSet(81): " + set2.tailSet(81));
		System.out.println("set2.subSet(0,10): " + set2.subSet(7, 15));
	}

	private static void setFromList()
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
	}

	private static void testTreeSetAdd()
	{
		Set<Integer> treeSet = new TreeSet<>();
		long timer = System.currentTimeMillis();
		for (int i = 0; i <= 100000; i++)
			treeSet.add(i);
		timer = System.currentTimeMillis() - timer;
		System.out.println(">>> time for TreeSet: " + timer);
		System.out.println(">>> treeSet.size: " + treeSet.size());
	}

	private static void testHashSetAdd()
	{
		Set<Integer> hashSet = new HashSet<>();
		long timer = System.currentTimeMillis();
		for (int i = 0; i <= 100000; i++)
			hashSet.add(i);
		timer = System.currentTimeMillis() - timer;
		System.out.println(">>> time for HashSet: " + timer);
		System.out.println(">>> hashSet.size: " + hashSet.size());
	}

	private static void testLinkedListAdd()
	{
		List<Integer> linkedList = new LinkedList<>();
		long timer = System.currentTimeMillis();
		for (int i = 0; i <= 100000; i++)
			linkedList.add(i);
		timer = System.currentTimeMillis() - timer;
		System.out.println(">>> time for LinkedList: " + timer);
		System.out.println(">>> linkedList.size: " + linkedList.size());

	}
}
