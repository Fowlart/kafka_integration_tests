package groovy.operator_overriding

class MyBigDecimal extends BigDecimal {

    MyBigDecimal(String val) {
        super(val)
    }

    MyBigDecimal plus(Integer integer) {
        println("plus in action")
        return new MyBigDecimal((this.doubleValue() + integer.doubleValue()).toString())
    }

    static void main(String[] args) {
        MyBigDecimal a = new MyBigDecimal("7")
        Integer b = 3
        print(a + b)
    }
}
