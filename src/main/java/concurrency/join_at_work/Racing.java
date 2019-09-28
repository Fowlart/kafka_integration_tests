package concurrency.join_at_work;

public class Racing
{

	public static void main(String[] args) throws InterruptedException {

		TestJoinClass fastest = new TestJoinClass("_fastest", 500);
		TestJoinClass medium = new TestJoinClass("__medium", 600);
        TestJoinClass slowest = new TestJoinClass("___slowest", 700);

        fastest.start();
        medium.start();
        medium.join(); // / will make sure that THIS THREAD is terminated before the next instruction is executed by the program.
        slowest.start();

	}
}
