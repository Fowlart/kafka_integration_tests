package collections.interfaces.ordering;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Name implements Comparable<Name>
{
	// Name objects are immutable. All other things being equal, immutable types are the way to go,
	// especially for objects that will be used as elements in Sets or as keys in Maps.
	// These collections will break if you modify their elements or keys while they're in the collection.
	private final String firstName, lastName;

	// This field for providing example of custom ordering  
	private int index;

	public int getIndex()
	{
		return index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	// The constructor checks its arguments for null. This ensures that all Name objects are well formed so that none
	// of the other methods will ever throw a NullPointerException
	public Name(String firstName, String lastName)
	{
		if (firstName == null || lastName == null)
			throw new NullPointerException();
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public String firstName()
	{
		return firstName;
	}

	public String lastName()
	{
		return lastName;
	}

	// The equals method returns false if the specified object is null or of an inappropriate type.
	// The compareTo method throws a runtime exception under these circumstances.
	// Both of these behaviors are required by the general contracts of the respective methods.
	public boolean equals(Object o)
	{
		if (!(o instanceof Name))
			return false;
		Name n = (Name) o;
		return n.firstName.equals(firstName) && n.lastName.equals(lastName);
	}

	// The hashCode method is redefined. This is essential for any class that redefines the equals method. (Equal objects must have equal hash codes.)
	@Override
	public int hashCode()
	{
		return 31 * firstName.hashCode() + lastName.hashCode();
	}

	@Override
	public String toString()
	{
		return firstName + " " + lastName;
	}

	@Override
	public int compareTo(Name n)
	{
		int lastCmp = lastName.compareTo(n.lastName);
		return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
	}


	public static void main(String[] args)
	{
		// 1 - natural ordering
		Name nameArray[] =
		{
				new Name("John", "Smith"),
				new Name("Karl", "Ng"),
				new Name("Jeff", "Smith"),
				new Name("Tom", "Rich")
		};

		List<Name> names = Arrays.asList(nameArray);
		Collections.sort(names);
		System.out.println(names);

		//2 - custom ordering
		int index = 4;
		for (Name name : names)
		{
			name.setIndex(index);
			index--;
		}
		Collections.sort(names, Comparator.comparing(name -> Integer.valueOf(name.getIndex())));
		System.out.println(names);
	}

}
