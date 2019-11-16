package groovy.primitives

class PrimitivesDontExist {

    static void main(String[] args) {

        int prim = 10 // just look like int, but it is Integer
        print(prim.doubleValue())

        //It executes this expression as 1.plus(1), calling the plus() method of the first Integer object, and passing2the second Integer object as an argument
        assert (2 == 1 + 1)


    }
}
