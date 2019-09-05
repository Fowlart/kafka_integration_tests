package collections;

import java.util.Collection;
import java.util.Collections;


public class Utils
{
	public static void writeLine(int examplNumber)
	{
		System.out.println("______________" + examplNumber + "______________");
	}

	public static void outPutCollection(Collection collection1, Collection collection2, String operationDescribe)
	{
		System.out.println("______________" + operationDescribe + "______________");
		System.out.println("collection A: " + collection1);
		System.out.println("collection B: " + collection2);
	}
}
