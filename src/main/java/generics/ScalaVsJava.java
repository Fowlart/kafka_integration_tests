package generics;

class MyList<A> {
}

class Animal {
}

class Dog extends Animal {
}

public class ScalaVsJava {
    public static void main(String[] args) {
        //  MyList<Animal> list = new MyList<Dog>(); // will not compile
        MyList<? extends Animal> covariantList = new MyList<Dog>(); // covariance
        MyList<? super Dog> contravariantList = new MyList<Animal>(); //

    }
}