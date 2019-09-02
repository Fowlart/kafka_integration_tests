package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class BaseCollectionsMethods
{

	private static void reFillCollection(Collection collection, int howManyElements){
		Random random = new Random(47);
		collection.clear();
		for (int i = 0; i <= howManyElements; i++)
		{
			collection.add(random.nextInt(100));
		}
	}

	public static void main(String[] args)
	{
		Collection<Integer> collection = new ArrayList<>();
		reFillCollection(collection,20);
		System.out.println("collection: " + collection);
		System.out.println("collection.stream(): " + collection.stream().count());
		System.out.println("collection.iterator(): " + collection.iterator());
		System.out.println("collection.size(): " + collection.size());
		System.out.println("collection.add(999):");
		collection.add(999);
		System.out.println(collection);
		System.out.println("collection.remove(999):");
		collection.remove(999);
		System.out.println(collection);

		Collection<Integer> collection2 = new ArrayList();
		reFillCollection(collection2,10);
		Utils.outPutCollection(collection,collection2,"collection.retainAll(collection2)");
		collection.retainAll(collection2);
		System.out.println(collection);

		reFillCollection(collection,20);
		reFillCollection(collection2,10);
		Utils.outPutCollection(collection,collection2,"collection.removeAll(collection2)");
		collection.removeAll(collection2);
		System.out.println(collection);

		reFillCollection(collection,20);
		reFillCollection(collection2,10);
		Utils.outPutCollection(collection,collection2,"collection.containsAll(collection2)");
		System.out.println(collection.containsAll(collection2));
	}
}
