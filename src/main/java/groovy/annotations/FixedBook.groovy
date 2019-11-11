package groovy.annotations

import groovy.transform.Immutable

@Immutable
class FixedBook {
    String title

    static void main(String[] args) {
        /** Annotation @Immutable make allow us not to create accessors method for property*/
        def gina = new FixedBook('Groovy in Action')
        def regina = new FixedBook(title: 'Groovy in Action')
        assert gina.title == 'Groovy in Action'
        assert gina == regina
        try {
            gina.title = "Oops!"
            assert false, "should not reach here" // this assert will stop the program execution and print out msg
        } catch (ReadOnlyPropertyException expected) {
            println "Expected Error: '$expected.message'"
        }
    }

}