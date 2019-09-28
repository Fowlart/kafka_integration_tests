package concurrency;

import java.util.Random;


class MyThread implements Runnable
{

	static String importantInfo[] =
	{
			"Mares eat oats",
			"Does eat oats",
			"Little lambs eat ivy",
			"A kid will eat ivy too"
	};

	@Override
	public void run()
	{

		for (int i = 0; i < importantInfo.length; i++)
		{
			//Pause for 4 seconds
			System.out.println(importantInfo[i]);
			try
			{
				/***
				 * Many methods that throw InterruptedException, such as sleep, are designed to cancel their current operation and
				 * return immediately when an interrupt is received.
				 ***/
				Thread.sleep(4000);
			}
			catch (InterruptedException e)
			{
				System.err.println(Thread.currentThread().getId() + " WAS INTERRUPTED ");
			}
			//Print a message
		}
	}
}

class MyThreadWithoutInterruption implements Runnable
{
	/***
	 * What if a thread goes a long time without invoking a method that throws InterruptedException? Then it must
	 * periodically invoke Thread.interrupted, which returns true if an interrupt has been received.
	 ***/
	private static Random random = new Random(47);

	@Override
	public void run()
	{

		for (int i = 0; i < 1000; i++)
		{
			System.out.print("+");
			if (Thread.interrupted())
			{
				System.out.println();
			}
		}
	}
}


public class Interrupts
{
	public static void main(String args[]) throws InterruptedException
	{
		//1 
		Thread forInterruption_1 = new Thread(new MyThread());
		forInterruption_1.start();
		Thread.sleep(3000);
		forInterruption_1.interrupt();

		/** Give us unpredictable lines */
		Thread forInterruption_2 = new Thread(new MyThreadWithoutInterruption());
		forInterruption_2.start();
		for (int i = 0; i <= 10; i++)
		{
			Thread.sleep(1);
			forInterruption_2.interrupt();
		}
	}
}
