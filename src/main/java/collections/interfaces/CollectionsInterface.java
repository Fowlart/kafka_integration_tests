package collections.interfaces;

import collections.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
/** The Collection Interface https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html */
public class CollectionsInterface
{

	private static void reFillCollection(Collection collection, int howManyElements)
	{
		Random random = new Random(47);
		collection.clear();
		for (int i = 0; i <= howManyElements; i++)
		{
			collection.add(random.nextInt(100));
		}
	}

	public static void main(String[] args)
	{
		/**
		 * By convention all general-purpose collection implementations have a constructor that takes a Collection argument.
		 * This constructor, known as a conversion constructor, initializes the new collection to contain all of the elements in
		 * the specified collection, whatever the given collection's subinterface or implementation type. In other words, it
		 * allows you to convert the collection's type:
		 */
		Collection<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
		Collection<Integer> b = new LinkedList<>(a);
		System.out.println(b);

		/**
		 * The Collection interface contains methods that perform basic operations, such as int size(), boolean isEmpty(),
		 * boolean contains(Object element), boolean add(E element), boolean remove(Object element), and Iterator<E> iterator().
		 * It also contains methods that operate on entire collections, such as boolean containsAll(Collection<?> c), boolean
		 * addAll(Collection<? extends E> c), boolean removeAll(Collection<?> c), boolean retainAll(Collection<?> c), and void
		 * clear(). Additional methods for array operations (such as Object[] toArray() and <T> T[] toArray(T[] a) exist as well
		 */

		Collection<Integer> collection = new ArrayList<>();
		reFillCollection(collection, 20);
		System.out.println("collection: " + collection);
		System.out.println("collection.stream(): " + collection.stream().count());
		System.out.println("collection.iterator(): " + collection.iterator());
		System.out.println("collection.size(): " + collection.size());
		System.out.println("collection.add(999): "+collection.add(999));
		System.out.println(collection);
		System.out.println("collection.remove(999): "+collection.remove(999));
		System.out.println("collection.remove(1999): "+collection.remove(1999));
		System.out.println(collection);

		// intersection
		Collection<Integer> collection2 = new ArrayList();
		reFillCollection(collection2, 10);
		Utils.outPutCollection(collection, collection2, "collection.retainAll(collection2)");
		collection.retainAll(collection2);
		System.out.println(collection);

		// difference
		reFillCollection(collection, 20);
		reFillCollection(collection2, 10);
		Utils.outPutCollection(collection, collection2, "collection.removeAll(collection2)");
		collection.removeAll(collection2);
		System.out.println(collection);

		reFillCollection(collection, 20);
		reFillCollection(collection2, 10);
		Utils.outPutCollection(collection, collection2, "collection.containsAll(collection2)");
		System.out.println(collection.containsAll(collection2));
	}
}
