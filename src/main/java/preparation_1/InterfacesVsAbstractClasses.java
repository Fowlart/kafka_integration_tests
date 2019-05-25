package preparation_1;

public class InterfacesVsAbstractClasses {
    public static void main(String[] args) {

        /**Взяли і створили екземпляр інтерфейсу :)*/
        Animal animal = new Animal(){};

        /** Static методи і поля інтерфейсу неявно макнуті як final!!!
         *  Ми не можемо їх змінювати. */
        //preparation1.Animal.size=16;
        System.out.println(Animal.name);
        System.out.println(Animal.size);

        animal.voice();

        Dog dog = new Dog() {};
        System.out.println(dog.name);
        System.out.println(dog.size);
        dog.size=100;
        dog.voice();
    }
}
interface Animal {
    public static int size=14;
    public static String name="preparation1.Animal";
    default void voice(){
        System.out.println("Some voice");
    }
}

abstract class Dog {
    int size = 25;
    private int psize=50;
    String name ="Doggi";

    void voice(){
        System.out.println("Gav-gav");
        angry();
    }

    private void angry(){
        System.out.println("i am angry!!!");
    }
}