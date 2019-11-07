package groovy.assertions

class UsingAssertions2 {
    static void main(String[] args) {
        // how to write an assertion
        assert ('text' * 3 << 'hello').size() == 4 * 3 + 5
    }
}
