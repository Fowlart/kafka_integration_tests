package collections.exercises;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class RandomOrderPrinter
{

	public static void main(String[] args)
	{
		List<Integer> collection = new LinkedList<>();
		Random random = new Random(47);

		while (collection.size() <= 100)
		{
			collection.add(random.nextInt(1000));
		}

		System.out.println("unsorted collection: " + collection);
		Collections.sort(collection);
		System.out.println("sorted collection: " + collection);
		Collections.shuffle(collection);
		System.out.println("shuffled collection: " + collection);

		collection.stream().sorted().forEach(integer -> System.out.print(integer+", "));

	}

}
