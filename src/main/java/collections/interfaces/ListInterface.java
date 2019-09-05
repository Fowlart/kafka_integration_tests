package collections.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Random;


public class ListInterface

/**
 * A List is an ordered Collection (sometimes called a sequence). Lists may contain duplicate elements. In addition to
 * the operations inherited from Collection, the List interface includes operations for the following:
 *
 * Positional access — manipulates elements based on their numerical position in the list. This includes methods such as
 * get, set, add, addAll, and remove. Search — searches for a specified object in the list and returns its numerical
 * position. Search methods include indexOf and lastIndexOf. Iteration — extends Iterator semantics to take advantage of
 * the list's sequential nature. The listIterator methods provide this behavior. Range-view — The sublist method
 * performs arbitrary range operations on the list.
 */
{

	public static <E> void swap(List<E> a, int i, int j)
	{
		E tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}

	public static void shuffle(List<?> list, Random rnd)
	{
		for (int i = list.size(); i > 1; i--)
			swap(list, i - 1, rnd.nextInt(i));
	}

	public static void main(String[] args)
	{
		// 1) The basic positional access operations are get, set, add and remove.
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 10));
		//Collections.swap();
		swap(list, 0, 5);
		System.out.println(list);
		swap(list, 5, 0);
		System.out.println(list);
		//Collections.shuffle();
		shuffle(list, new Random(47));
		System.out.println(list);


		// 2) As you'd expect, the Iterator returned by List's iterator operation returns the elements of the list in proper sequence. List also provides a richer
		// iterator, called a ListIterator, which allows you to traverse the list in either direction, modify the list during iteration, and obtain the current position of the iterator.
		ListIterator<Integer> listIterator = list.listIterator();
		System.out.println(listIterator.hasNext());
		System.out.println(listIterator.hasPrevious());
		System.out.println("listIterator.previousIndex(): " + listIterator.previousIndex());
		System.out.println(listIterator.next());
		System.out.println(listIterator.previous());
		try
		{
			System.out.println(listIterator.previous());
		}
		catch (NoSuchElementException exception)
		{
			System.out.println(">>> " + exception.toString());
		}
		System.out.println(listIterator.nextIndex());
		System.out.println(listIterator.next());
		System.out.println(listIterator.nextIndex());
		System.out.println(list);
		ListIterator<Integer> listIteratorFromIndex = list.listIterator(4);
		System.out.println(listIteratorFromIndex.hasPrevious());
		System.out.println(listIteratorFromIndex.previous());

		//3) Range-View Operation. As the term view implies, the returned List is backed up by the List on which subListwas called, so changes in the former are reflected in the latter.
		System.out.println(">>> Range-View Operation");
		System.out.println(list);
		{
		    ListIterator<Integer> listIterator1 = list.subList(0, 5).listIterator(3);
		    listIterator1.add(999);
		}
		System.out.println(list);
	}
}
