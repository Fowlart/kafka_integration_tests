package collections;

import java.util.Arrays;

public class NullInStringsList {
    public static void main(String[] args) {
       boolean result = Arrays.asList("PURCHASE_PRICE_PRESENTATION_TITLE", "CONTRACT_BID_PRICE_PRESENTATION_TITLE",
                        "CONTRACT_SPCL_MOQ",null).contains(null);

       System.out.println("result is:"+result);
    }
}
