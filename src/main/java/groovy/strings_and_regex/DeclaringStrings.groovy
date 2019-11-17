package groovy.strings_and_regex

class DeclaringStrings {

    static void main(String[] args) {

        //  The double-quoted form is the equivalent of the single-quoted form, except that if the text contains unescaped
        //  dollar signs, the dollar sign introduces a placeholder, and the string will be treated as a GString instead
        //  of a plain string. GStrings are covered in more detail in the next section.
        def name = "Artur"
        println("My name is $name")

        //  The single-quoted form never pays any attention to placeholders.
        //  This is closely equivalent to Java string literals.
        println('My name is $name')

        // New lines are always treated as \n in '''<text>'''
        println('''Text:
its batter to write something just using that kind of Strings
aaassaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa''')


        def a = "<some text>"
        println(/x(\d*)y\$a/)
    }
}
