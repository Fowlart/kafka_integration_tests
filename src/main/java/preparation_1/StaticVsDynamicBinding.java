package preparation_1;

public class StaticVsDynamicBinding {
    public static void main(String[] arg) {
        MadCow madCow = new MadCow();
        System.out.println(madCow);
        //upcasting
        Cow cow = (Cow)madCow;
        System.out.println(cow);
        cow = new Cow();
        System.out.println(cow);
    }
}
class Cow {
    private void eat() {
        System.out.println("preparation1.Cow is eating...");
    }

    @Override
    public String toString() {
        eat();
        return "preparation1.Cow{}";
    }
}

class MadCow extends Cow {
    private void eat() {
        System.out.println("Mad caw is eating...");
    }

    @Override
    public String toString() {
        eat();
        return "preparation1.MadCow{}";
    }
}
