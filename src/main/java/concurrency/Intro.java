package concurrency;


class HelloRunnable implements Runnable
{
	public void run()
	{
		System.out.println("Hello from a Runnable!");
	}
}

class HelloThread extends Thread
{
	public void run()
	{
		System.out.println("Hello from a Thread!");
	}
}

public class Intro
{

	public static void main(String[] args)
	{
		/**
		 * The first idiom, which employs a Runnable object, is more general, because the Runnable object can subclass a class
		 * other than Thread.
		 **/
		(new Thread(new HelloRunnable())).start();

		/**
		 * The second idiom is easier to use in simple applications, but is limited by the fact that your task class must be a
		 * descendant of Thread.
		 */
		new HelloThread().run();

		(new Thread(() -> System.out.println("Lambda thread!"))).start();
	}
}
