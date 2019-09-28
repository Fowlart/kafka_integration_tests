package concurrency;

import java.util.concurrent.atomic.AtomicBoolean;

class Bomb extends Thread
{
    private AtomicBoolean active = new AtomicBoolean(false);

    @Override
	public void run()
	{
	    while (true)
		{
			try
			{
				Thread.sleep(500);
				if (active.get())
					active.set(false);
				else
					active.set(true);
			}
			catch (InterruptedException e)
			{
				System.out.println(active);
			}
		}
	}
}

public class Interrupts2
{
	public static void main(String[] args) throws InterruptedException {
	    Bomb bomb = new Bomb();
	    bomb.start();
	    Thread.sleep(500);
	    bomb.interrupt();
	}
}
