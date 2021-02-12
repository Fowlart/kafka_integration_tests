package stack_heep;

class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class PersonBuilder {
    private static Person buildPerson(int id, String name) {
        // The call to the parameterized constructor Person(int, String) from main() will allocate further memory
        // on top of the previous stack. This will store:

        // - The 'this' object reference of the calling object in stack memory
        // - The primitive value id in the stack memory
        // - The reference variable of String argument name which will point to the actual string from string pool in heap memory
        return new Person(id, name);
    }

    // Upon entering the main() method, a space in stack memory would be created to store primitives and references of this method
    public static void main(String[] args) {
        int id = 23; //The primitive value of integer id will be stored directly in stack memory
        String name = "John";
        Person person = null; // The reference variable person of type Person will also be created in stack memory which will point to the actual object in the heap

        person = buildPerson(id, name);
    }
}