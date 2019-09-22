package generics.factory_method_generics;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


interface MyCreator<E extends Number>
{
	E getNumber();
}

class IntegerCreator implements MyCreator
{
	static Random random = new Random(47);

	@Override
	public Integer getNumber()
	{
		return random.nextInt(100);
	}
}

class DoubleCreator implements MyCreator
{
	static Random random = new Random(47);

	@Override
	public Double getNumber()
	{
		return random.nextDouble();
	}
}

public class MyFactoryMethod
{
	public static void main(String[] args)
	{
		List<MyCreator> list = Arrays.asList(new DoubleCreator(), new IntegerCreator());

		int a = 0;

		while (a != 50)
		{
			for (MyCreator creator : list)
			{
				a = creator.getNumber().intValue();
				System.out.println(a);
			}
		}

	}
}
