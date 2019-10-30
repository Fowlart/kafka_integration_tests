package preparation_1;

public class FinalTest {

	public final void dontOverload(int x)
	{
	}

	public void dontOverload(double x)
	{
	}

    public static void main(String[] args) {
        FinalTest finalTest = new FinalTest();
        finalTest.dontOverload(new Integer(3));
        finalTest.dontOverload(new Double(2));
    }
}
