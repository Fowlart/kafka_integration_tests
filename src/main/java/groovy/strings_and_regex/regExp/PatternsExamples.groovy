package groovy.strings_and_regex.regExp

class PatternsExamples {
    static void main(String[] args) {

        def twister = 'she sells sea shells at the sea shore of seychelles'
// twister must contain a substring of size 3 that starts with s and ends with a
        assert twister =~ /s.a/ // =~ - find operator, will create java.util.regex.Matcher
        println(twister =~ /s.a/)
        def finder = (twister =~ /s.a/) // finder becomes java.util.regex.Matcher
        assert finder instanceof java.util.regex.Matcher // last statement - true
// twister must contain only words delimited by single spaces
        assert twister ==~ /(\w+ \w+)*/    //the regex match operator, ==~
        println(twister ==~ /(\w+ \w+)*/) // will evaluate to boolean

        def WORD = /\w+/ //can create variables for many regular expression
        boolean matches = (twister ==~ /($WORD $WORD)*/)
        assert matches instanceof java.lang.Boolean

        assert !(twister ==~ /s.e/)
        def wordsByX = twister.replaceAll(WORD, 'x')
        assert wordsByX == 'x x x x x x x x x x'
        def words = twister.split(/ /)
        assert words.size() == 10
        assert words[0] == 'she'


    }
}
