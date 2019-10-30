package preparation_1;

public class FieldsOverriding {

    public static void main(String[] args) {
        Sub c1 = new Sub();
        System.out.println(c1.s);

        /** Створюємо нову змінну, та розширюємо її  до батьківського інтерфейсу*/
        Super c2 = new Sub();
        System.out.println(c2.s);
		/** Звужуємо, дивимся що відбувається */
		System.out.println(((Sub) (c2)).s);
    }
}

class Super {
    String s = "preparation1.Super";
}

class Sub extends Super {
    Integer s = 123;
}



