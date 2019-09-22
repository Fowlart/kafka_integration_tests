package generics.legacy_usage;

import java.util.Collection;


public class Inventory
{
    /**
	 * Adds a new Assembly to the inventory database. The assembly is given the name name, and consists of a set parts
	 * specified by parts. All elements of the collection parts must support the Part interface.
	 **/

    /**
     * When a generic type like Collection is used without a type parameter, it's called a raw type.
     **/
	public static void addAssembly(String name, Collection parts)
	{
	}

	public static Assembly getAssembly(String name)
	{
	    return null;
	}
}
