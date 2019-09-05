package collections;

import java.util.HashSet;
import java.util.Random;


public class HashSetExample
{

	public static void main(String[] args)
	{
	    /** Benefits from the caching is that add(), contains(), remove(), size() take constant amount of time.*/
		HashSet<Integer> hashSet = new HashSet();
		Random random = new Random(47);
		for (int i = 0; i <= 100; i++)
		{
			hashSet.add(new Integer(random.nextInt(100)));
		}
		System.out.println(hashSet);



	}
}
