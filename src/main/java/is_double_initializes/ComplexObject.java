package is_double_initializes;

import java.util.Optional;

class MoreComplexObject {
    ComplexObject complexObject;

    public ComplexObject getComplexObject() {
        return complexObject;
    }

    public void setComplexObject(ComplexObject complexObject) {
        this.complexObject = complexObject;
    }
}

public class ComplexObject {
    private java.lang.Double aDouble;
    private int anInt;
    private boolean aBoolean;

    public Double getaDouble() {
        return aDouble;
    }

    public void setaDouble(Double aDouble) {
        this.aDouble = aDouble;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public static void main(String[] args) {

        ComplexObject complexObject = new ComplexObject();

        // Primitives are initialized, but nonPrimitives - not
        System.out.println(complexObject.getaDouble());
        System.out.println(complexObject.getAnInt());
        System.out.println(complexObject.aBoolean);

        complexObject.setaDouble(15d);
        Optional<Double> doubleOptional = Optional.ofNullable(complexObject.getaDouble());
        System.out.println(doubleOptional.orElse(0d));

        MoreComplexObject moreComplexObject = new MoreComplexObject();

        // null pointer here
        //    System.out.println(Optional.ofNullable(moreComplexObject.getComplexObject().getaDouble()).orElse(0d));

        ComplexObject stub = new ComplexObject();
        stub.setaDouble(111d);

        System.out.println(Optional.ofNullable(moreComplexObject.getComplexObject()).orElse(stub).getaDouble());
    }
}
