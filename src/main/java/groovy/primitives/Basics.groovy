package groovy.primitives

class Basics {
    static void main(String[] args) {
        // Literal declaration. (60*60*24*365) treating like Double(Number) object.
        println((60 * 60 * 24 * 365).doubleValue()) // invalid in Java

        // Can use '+' and '-' operators on Strings
        assert "abc" - "a" + "a" == "bca"
    }
}