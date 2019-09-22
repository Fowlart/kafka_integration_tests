package collections.exercises;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TrimingStrings
{
	public static void main(String[] args)
	{
		List<String> strings = Arrays.asList("Not  .  trimmed  . strings".split("\\."));
		System.out.println("inputed list: " + strings);
		//1
		System.out.println("result: " + strings.stream().map(String::trim).collect(Collectors.toList()));

		//2
		List<String> resultList = new LinkedList<>();
		for (String s : strings)
		{
			resultList.add(s.trim());
		}
		System.out.println("2 result: " + resultList);

		// Strings - immutable. Will not work!
		Iterator<String> iterator = strings.iterator();
		while (iterator.hasNext())
		{
		    iterator.next().trim();
		}
		System.out.println("3 result: "+strings);
	}
}
