package preparation_1.static_experiments;

public class StaticVsDynamicBinding {
    public static void main(String[] arg) {
        MadCow madCow = new MadCow();
        System.out.println(madCow);
        //upcasting
        Cow cow = madCow;
        System.out.println(cow);
        cow = new Cow();
        System.out.println(cow);

        /**Static method can not be Override **/
        Cow.getStaticText();
        System.out.println(madCow.getStaticText());
        System.out.println(((Cow)madCow).getStaticText());


        Cow art = new Cow();
        System.out.println(((MadCow)art).getStaticText());


    }
}

class Cow {
    private void eat() {
        System.out.println("Cow is eating...");
    }

    @Override
    public String toString() {
        eat();
        return "Cow{}";
    }

    public static String getStaticText() {
        return "i am cow";
    }
}

class MadCow extends Cow {
    private void eat() {
        System.out.println("Mad caw is eating...");
    }

    @Override
    public String toString() {
        eat();
        return "MadCow{}";
    }

    // @Override // will produce an error
    public static String getStaticText() {
        return "i am mad cow";
    }


}
