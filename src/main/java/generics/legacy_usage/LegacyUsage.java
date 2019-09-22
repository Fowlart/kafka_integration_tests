package generics.legacy_usage;

import java.util.ArrayList;
import java.util.Collection;

public class LegacyUsage
{
	public static void main(String[] args)
	{
		// new code
		Collection<Part> c = new ArrayList<>();
		c.add(new Guillotine());
		c.add(new Blade());

		/**
		 * When we call addAssembly, it expects the second parameter to be of type Collection. The actual argument is of type
		 * Collection<Part>. This works, but why? After all, most collections don't contain Part objects, and so in general, the
		 * compiler has no way of knowing what kind of collection the type Collection refers to.
		 */
		Inventory.addAssembly("thingee", c);

		Assembly returned = Inventory.getAssembly("thingee");

		/**
		 * The warning is needed, because the fact is that the compiler can't guarantee its correctness. We have no way of
		 * checking the legacy code in getAssembly() to ensure that indeed the collection being returned is a collection of
		 * Parts. The type used in the code is Collection, and one could legally insert all kinds of objects into such a
		 * collection.
		 **/
		Collection<Inventory> collection = returned.getParts();
	}
}
