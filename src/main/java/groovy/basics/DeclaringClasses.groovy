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

        // loop definition
        def partyPeople = 100
        1.upto(partyPeople) {print it}
    }
}