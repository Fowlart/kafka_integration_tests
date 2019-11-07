package groovy.basics

class DeclaringClasses {

    static void main(String[] args) {
        Book book = new Book("Groovy in action")
        assert book.getTitle() != null

        // reflection :)
        println(book.getProperty("title"))
        println(book.getTitle())

        def groovyBook = new BookBean()

        // automatic generations setter-methods
        groovyBook.setTitle('Groovy in Action')
        assert groovyBook.getTitle() == 'Groovy in Action'

        // Also note that groovyBook.title is not a field access. Instead, it’s a shortcut for the corresponding accessor method.
        groovyBook.title = 'Groovy conquers the world'
        assert groovyBook.title == 'Groovy conquers the world'


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