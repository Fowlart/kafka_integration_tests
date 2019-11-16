package groovy.control_flow

class BasicControlFlow {
    static void main(String[] args) {

        def sum = 0
        for (increment in 0..5) {
            sum += increment
        }
        println(sum)


        def list = [0, 1, 2, 3]
        for (j in list) {
            assert j == list[j]
        }

        list.each() { item -> assert item == list[item] }

        switch (3) {
            case 1:
                assert false
                break
            case 3:
                assert true
                break
            default:
                assert false
        }
    }
}