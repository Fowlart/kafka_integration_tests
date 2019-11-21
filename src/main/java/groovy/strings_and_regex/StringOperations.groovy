package groovy.strings_and_regex

class StringOperations {
    static void main(String[] args) {
        String greeting = 'Hello Groovy!'
        assert greeting.startsWith('Hello')
        assert greeting.getAt(0) == 'H'

        assert greeting[0] == 'H' // ???Syntax???

        assert greeting.indexOf('Groovy') >= 0
        assert greeting.contains('Groovy')
        assert greeting[6..11] == 'Groovy'
        assert 'Hi' + greeting - 'Hello' == 'Hi Groovy!'//
        assert greeting.count('o') == 3

        // text transforming operations
        println('x'.padLeft(3))
        println('x'.padRight(3, '_'))
        println('x'.center(3))
        println('x' * 3 == 'xxx')

        println(greeting - 'Groo')
    }
}
