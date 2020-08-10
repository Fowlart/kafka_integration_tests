import java.util.Objects;

public class NonNullArray {
    public static void main(String[] args) {

        byte [] amas = {1,2,3,6,2}; // cannot add null to the array

        if (Objects.nonNull(amas)) {
            System.out.println(amas);
        }

        amas = null;

        if (Objects.isNull(amas)) {
            System.out.println("Exception");
        }

    }
}
