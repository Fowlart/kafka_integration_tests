package collections;

import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;

public class NavigableSetExamples
{
	public static void main(String[] args)
	{
		Random random = new Random(47);
		NavigableSet<Integer> set = new TreeSet();
		for (int i = 0; i <= 100; i++)
		{
			set.add(random.nextInt(100));
		}

		System.out.println(set);

		System.out.println(
				"lower() – возвращает наибольший элемент в наборе, но строго меньше чём заданный если такого элемента нет, то в результате будет возвращено null: "
						+
						set.lower(15));
		System.out.println(
				"floor()– возвращает наибольший элемент в наборе, но меньше чём заданный или равный ему, в случае отсутствия такого элемента будет возвращено null: "
						+
						set.floor(100));
		System.out.println(
				"ceiling() – возвращает ближайший элемент в наборе, но который больше или равняется заданному, в случае отсутствия такого элемента будет возвращено null: "
						+
						set.ceiling(35));
		System.out.println(
				"higher() – возвращает ближайший элемент в наборе, но строго больше чём заданный, в случае отсутствия такого элемента будет возвращено null: "
						+
						set.ceiling(100));

		System.out.println(set.descendingSet());
	}
}
