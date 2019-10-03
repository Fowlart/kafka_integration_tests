package concurrency;

public class ThreadException
{
	public static void main(String[] args)
	{
		Runnable runnable = () -> {
		    System.out.println("working");
            System.out.println(Thread.currentThread().getState());
            System.out.println(Thread.currentThread().isAlive());
			throw new RuntimeException("");
		};
		Thread thread = new Thread(runnable);
		try
		{
			thread.run();
		}
		catch (RuntimeException ex)
		{
			System.out.println(thread.getState());
			System.out.println(thread.isAlive());
		}

		System.out.println(thread.getState());
	}
}
