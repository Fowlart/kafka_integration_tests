package groovy.strings_and_regex

class GStringsSeparation {
    static void main(String[] args) {
        def me = 'Tarzan'
        def you = ' Jane'
        def line = "me $me - you $you"
        assert line instanceof GString
        line.strings.each {print it}
        line.values.each {print it}
    }
}