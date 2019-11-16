package groovy.assertions

class UsingAssertions1 {

    /** Assertions serve multiple purposes:
     * ■ They can be used to reveal the current program state
     * ■ They often make good replacements for line comments, because they reveal assumptions and verify them at the same time.
     **/

    static void main(String[] args) {

        // basics assert concepts
        assert (true)
        assert 1 == 1

        // Note that nothing was revealed about the type of x. The def keyword means “dynamically typed.”
        def x = 1
        assert x == 1

        //This is the typical style when asserting the program status for the current line. It uses two statements on the same line, separated by a semicolon.
        def y = 1; assert y == 1

        // assert in loops
        List<Integer> list = new ArrayList<>()

        for (int i = 0; i <= 20; i++) {
            list.add(i);
        }

        // checking optional value
        Optional<Double> optional = Optional.empty()
        assert (!optional.isPresent())

        // What happens if an assertion fails? Pause and think about the language features required to provide such a sophisticated error message.
        assert (list.size() == 21)
        list.each {
            print it
        }

    }
}