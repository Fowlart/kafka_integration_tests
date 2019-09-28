/* This program demonstrates the use of some advanced thread 
 * methods, specifically sleep and join.  This class extends Thread
 * and therefore must override the run method. 
*/
package concurrency.join_at_work;

/**
 *
 * @author MFisher
 */
public class TestJoinClass extends Thread
{
	//Constructor to assign a user defined name to the thread
	public TestJoinClass(String name, int speed)
	{
		super(name);
		this.sped = speed;
	}

	final int sped;

	public void run()
	{
		for (int i = 1; i <= 5; i++)
		{
			try
			{
				Thread.sleep(sped);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
			System.out.println(Thread.currentThread().getName() +
					" i = " + i);
		}
		System.out.println(Thread.currentThread().getName()+" is finished!");
	}
}

