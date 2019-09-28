package concurrency;

class CounterSynchronized extends Counter
{
	private int c = 0;

	public synchronized void increment()
	{
		c++;
	}

	public synchronized void decrement()
	{
		c--;
	}

	public int value()
	{
		return c;
	}
}

public class SynchronizedMethods
{
	public static void main(String[] args) throws InterruptedException
	{

		CounterSynchronized counter = new CounterSynchronized();
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
