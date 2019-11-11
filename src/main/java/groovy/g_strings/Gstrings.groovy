package groovy.g_strings

class Gstrings {
    static void main(String[] args) {
        // inline replacement
        def nick = 'ReGina'
        def book = 'Groovy in Action, 2nd ed.'
        assert "$nick is $book" == 'ReGina is Groovy in Action, 2nd ed.'
        println("$nick is $book")

        // regular expression support
        println('12345'.replaceAll(/\d/, 'x'))
        println('12345'.replaceAll(/\d+/, 'x'))
    }
}
