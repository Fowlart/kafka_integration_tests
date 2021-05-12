import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String s = "abcd";

        char arr[] = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();

        for (int i=arr.length-1; i>=0; i--){
            stringBuffer.append(arr[i]);
        }
        System.out.println();
    }
}
