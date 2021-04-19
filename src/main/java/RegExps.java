import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExps {
    public static void main(String[] args) {

        String truncatedSearchString;

        String containerNumber = "U1234567";

        Pattern p = Pattern.compile("^[UNS]\\d{7}$");

        Matcher m = p.matcher(containerNumber);

        if (m.matches()) {
            truncatedSearchString = containerNumber.replaceFirst("[UNS]", StringUtils.EMPTY);
        } else {
            truncatedSearchString = containerNumber;
        }
        System.out.println(truncatedSearchString);
    }
}
