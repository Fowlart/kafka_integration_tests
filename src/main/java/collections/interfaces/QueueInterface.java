package collections.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;


public class QueueInterface
{
	public static void main(String[] args) throws InterruptedException
	{

		/**
		 * In the following example program, a queue is used to implement a countdown timer. Demonstration of add and remove
		 * methods
		 */
		countdown(10);

		/** Sorting based on PriorityQueue */
		Random random = new Random(47);
		List<Integer> unsorted = new LinkedList<>();
		for (int i = 0; i <= 100; i++)
			unsorted.add(random.nextInt(100));
		System.out.println(unsorted);
		System.out.println(heapSort(unsorted));
	}

	public static void countdown(Integer time) throws InterruptedException
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = time; i >= 0; i--)
			queue.add(i);
		while (!queue.isEmpty())
		{
			System.out.println(queue.remove());
			Thread.sleep(1000);
		}
	}

	static <E> List<E> heapSort(Collection<E> c)
	{
		Queue<E> queue = new PriorityQueue<E>(c);
		List<E> result = new ArrayList<E>();

		while (!queue.isEmpty())
			result.add(queue.remove());
		return result;
	}
}
