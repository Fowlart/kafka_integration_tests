package concurrency;


class Counter
{
	private int c = 0;

	public void increment()
	{
		c++;
	}

	public void decrement()
	{
		c--;
	}

	public int value()
	{
		return c;
	}

}

class Increaser implements Runnable
{
	private Counter counter;

	public Increaser(Counter counter)
	{
		this.counter = counter;
	}

	@Override
	public void run()
	{
		for (int i = 0; i <= 10000; i++)
			counter.increment();
	}

	public Counter getCounter()
	{
		return counter;
	}
}

class Decreaser implements Runnable
{

	private Counter counter;

	public Decreaser(Counter counter)
	{
		this.counter = counter;
	}

	@Override
	public void run()
	{
		for (int i = 0; i <= 10000; i++)
			counter.decrement();
	}
}

public class ThreadInterference
{
	public static void main(String[] args) throws InterruptedException
	{
		/***
		 * Thread A's result is lost, overwritten by Thread B. This particular interleaving is only one possibility. Under
		 * different circumstances it might be Thread B's result that gets lost, or there could be no error at all. Because they
		 * are unpredictable, thread interference bugs can be difficult to detect and fix.
		 ***/
		Counter counter = new Counter();
		Increaser increaser = new Increaser(counter);
		Decreaser decreaser = new Decreaser(counter);
		Thread a = new Thread(increaser);
		Thread b = new Thread(decreaser);
		a.start();
		b.start();
		Thread.sleep(1000);

		System.out.println("result is: " + counter.value());
	}
}
