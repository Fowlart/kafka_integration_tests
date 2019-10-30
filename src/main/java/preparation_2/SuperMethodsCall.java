package preparation_2;

class Parent
{

	public Parent()
	{
		System.out.println("Parent()");
	}

	public void a()
	{
		System.out.println("Parent.a");
	}
}

class Child extends Parent
{

	public Child()
	{
		System.out.println("Child()");
	}

	@Override
	public void a()
	{
		System.out.println("Child.a");
	}
}

public class SuperMethodsCall
{
	public static void main(String[] args)
	{
		// Initializing of Child will Initialize his Parent
		Child child = new Child();

		// Upcasting cant change method behavior
		Parent parent = child;
		parent.a();
	}
}
