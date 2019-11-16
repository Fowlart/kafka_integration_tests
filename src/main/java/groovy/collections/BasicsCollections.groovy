package groovy.collections

class BasicsCollections {
    static void main(String[] args) {
        // working with the list looks like you’re working with an array
        def roman = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII']
        assert roman[4] == 'IV'
        def somth = roman[4]
        println(somth.class)
        println(roman.size())
        roman[roman.size()++] = 'VIII'
        println(roman[8])

        // working with map
        def http = [100: 'CONTINUE', 200: 'OK', 400: 'BAD REQUEST']
        assert http[200] == 'OK'
        http[500] = 'INTERNAL SERVER ERROR'
        assert http.size() == 4
        http.each {
            println it
        }

        // working with range
        def x = 1..10
        assert x.contains(5)
        assert !x.contains(15)
        assert x.size() == 10
        assert x.from == 1
        assert x.to == 10
        assert x.reverse() == 10..1

        x.each { print it }
    }
}