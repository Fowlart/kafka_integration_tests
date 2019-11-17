package groovy.operator_overriding

import org.codehaus.groovy.runtime.typehandling.DefaultTypeTransformation

class Comparing {
    static void main(String[] args) {

        def a = "Artur"
        def b = "Olenka"

        print(DefaultTypeTransformation.compareEqual(a,b))
    }
}
