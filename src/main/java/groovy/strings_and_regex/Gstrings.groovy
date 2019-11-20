package groovy.strings_and_regex

import static java.util.Calendar.*

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

        // using placeholders
        def me = 'Tarzan'
        def you = 'Jane'
        def line = "me $me - you $you"
        assert line == 'me Tarzan - you Jane'

        TimeZone.default = TimeZone.getTimeZone('GMT')
        def date = new Date(0)
        def dateMap = [y: date[YEAR], m: date[MONTH], d: date[DAY_OF_MONTH]] // ???Syntax???
        def out = "Year $dateMap.y / Month $dateMap.m / Day $dateMap.d/" // Extended dot syntax
        println("'\$date.year:' $date.year") // Extended dot syntax
        println(dateMap)
        println(out)

        println("method build in text: ${getHundredZeros()}")

        def sql = """SELECT FROM MyTable WHERE Year = $dateMap.y""" // Multiline GStrings
        assert sql == """SELECT FROM MyTable WHERE Year = 1970"""
        println('''
Text:
its batter to write something just using that kind of Strings
aaassaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
''')

        out = "my 0.02\$" // Escaped dollar sign
        assert out == 'my 0.02$'// Literal dollar sign
    }

    static String getHundredZeros() {
        StringBuilder buf = new StringBuilder()
        for (int i = 0; i <= 100; i++) buf.append(i)
        return buf.toString()
    }
}