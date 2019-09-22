package generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

abstract class Shape
{
	public void draw()
	{
		System.out.println(">>>drawing " + this.getClass().getSimpleName());
	};
}

class Circle extends Shape
{
}

class Rectangle extends Shape
{
}


public class BoundedWildcards<T>
{

    // Shape is the upper bound of the wildcard
	public static void drawAll(List<? extends Shape> shapes)
	{
		for (Shape shape : shapes)
			shape.draw();
	}

	public static void main(String[] args)
	{

		List<Circle> circles = Arrays.asList(new Circle(), new Circle(), new Circle());
		List<Rectangle> rectangles = Arrays.asList(new Rectangle(), new Rectangle(), new Rectangle());

		drawAll(circles);
		drawAll(rectangles);

	}
}
