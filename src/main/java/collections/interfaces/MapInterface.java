package collections.interfaces;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Predicate;


public class MapInterface
{

	public static void doFreq(String[] args, Map<String, Integer> m)
	{
		// Initialize frequency table from command line
		for (String a : args)
		{
			Integer freq = m.get(a);
			m.put(a, (freq == null) ? 1 : freq + 1);
		}
		System.out.println(m.size() + " distinct words:");
		System.out.println(m);

	}

	static <K, V> Map<K, V> newAttributeMap(Map<K, V> defaults, Map<K, V> overrides)
	{
		Map<K, V> result = new HashMap<K, V>(defaults);
		result.putAll(overrides);
		return result;
	}

	/**
	 * At first, many people worry that these idioms may be slow because the Map has to create a new Collection instance
	 * each time a Collection view operation is called. Rest easy: There's no reason that a Map cannot always return the
	 * same object each time it is asked for a given Collection view. This is precisely what all the Map implementations in
	 * java.util do.
	 **/
	static void removeValues(Predicate<Integer> predicate, Map<String, Integer> map)
	{

		Iterator<Integer> iterator = map.values().iterator();
		while (iterator.hasNext())
		{
			Integer value = iterator.next();
			if (predicate.test(value))
				iterator.remove();
		}
	}

	static <K, V> boolean validate(Map<K, V> attrMap, Set<K> requiredAttrs, Set<K> permittedAttrs)
	{
		boolean valid = true;
		Set<K> attrs = attrMap.keySet();

		if (!attrs.containsAll(requiredAttrs))
		{
			Set<K> missing = new HashSet<K>(requiredAttrs);
			missing.removeAll(attrs);
			System.out.println("Missing attributes: " + missing);
			valid = false;
		}
		if (!permittedAttrs.containsAll(attrs))
		{
			Set<K> illegal = new HashSet<K>(attrs);
			illegal.removeAll(permittedAttrs);
			System.out.println("Illegal attributes: " + illegal);
			valid = false;
		}
		return valid;
	}


	public static void main(String[] args)
	{
		// 1 Map Interface Basic Operations
		String[] mas = "the the the following program generates a frequency table of the words found in its argument list."
				.split(" ");

		Map<String, Integer> hashMap = new HashMap<>();
		Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
		Map<String, Integer> treeMap = new TreeMap<>();

		doFreq(mas, hashMap);
		doFreq(mas, linkedHashMap);
		doFreq(mas, treeMap);

		//2 Map Interface Bulk Operations
		hashMap.clear();
		linkedHashMap.clear();

		hashMap.put("one", 1);
		hashMap.put("two", 2);
		hashMap.put("three", 3);

		linkedHashMap.put("four", 4);
		linkedHashMap.put("five", 5);
		linkedHashMap.put("six", 6);
		Map<String, Integer> newMap = newAttributeMap(hashMap, linkedHashMap);
		System.out.println(">>> newAttributeMap(hashMap,linkedHashMap): " + newMap);

		//3 Collection Views
		removeValues(integer -> integer > 3, newMap);
		System.out.println(newMap);

		//4 Fancy Uses of Collection Views: Map Algebra





	}
}
