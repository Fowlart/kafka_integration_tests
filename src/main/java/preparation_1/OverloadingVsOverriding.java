package preparation_1;

public class OverloadingVsOverriding {

    public void showNum(int a) {
        System.out.println("public void showNum(int a) " + a);
    }

    public void showNum(double a) {
        System.out.println("public void showNum(double a) " + a);
    }

    protected void showNum(float a) {
        System.out.println("protected void showNum(float a) " + a);
    }

    public int showNum(long a) {
        System.out.println("public int showNum(long a)");
        return (int) a;
    }

    /**
     * Порядок входження змінних при перезавантаженні методів ТЕЖ МАЄ ЗНАЧЕННЯ
     */
    public void showNum(int a, double b) {
        System.out.println("showNum(int a, double b)");
    }

    public void showNum(double b, int a) {
        System.out.println("showNum(double b, int a)");
    }

    public static void main(String[] args) {
        OverloadingVsOverriding a = new OverloadingVsOverriding();
        a.showNum(new Integer(2));
        a.showNum(new Double(2));
        a.showNum(new Float(2));
        a.showNum(new Long(2));
        a.showNum(new Double(2), new Integer(2));
        a.showNum(new Integer(2), new Double(2));
    }
}