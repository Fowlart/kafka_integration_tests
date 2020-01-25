package preparation_1.static_experiments;

public class StaticMethods {

    public static int static_int = 5;

    public int getStatic_int() {
        return static_int;
    }

    public void setStatic_int(int static_int) {
        StaticMethods.static_int = static_int;
    }

    public void nonStatic() {
        System.out.println("nonStatic");
        isStatic();
    }

    static void isStatic() {
        System.out.println("Static");
        //nonStatic();
    }
    static void isStatic(StaticMethods staticMethods) {
        staticMethods.nonStatic();
    }

    public static void main(String[] args) {
        StaticMethods.isStatic();
        StaticMethods.isStatic(new StaticMethods());
        StaticMethods staticMethods1 = new StaticMethods();
        StaticMethods staticMethods2 = new StaticMethods();
        staticMethods1.setStatic_int(999);
        System.out.println("staticMethods1.static_int = "+staticMethods1.getStatic_int());
        System.out.println("staticMethods2.static_int = "+staticMethods2.getStatic_int());
    }
}
