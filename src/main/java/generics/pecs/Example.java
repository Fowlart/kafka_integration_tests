package generics.pecs;

import java.util.Collection;

/** PECS" is from the collection's point of view. **/
public class Example
{
	public static void copyLists(Collection<? extends Integer> producer, Collection<? super Integer> consumer)
	{
	    /**Cant copy wise-versa. It produce compile error!*/
	    for (Integer number: producer) {
	        consumer.add(number);
        }
	}

	public static void main(String[] args)
	{


	}
}
