package groovy.primitives

class PrimitivesDontExist {

    static void main(String[] args) {
        int prim = 10 // just look like int, but it is Integer
        print(prim.doubleValue())

        assert 'ABCDE'.indexOf('C') == 2
    }
}
