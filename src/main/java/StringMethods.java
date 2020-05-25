import org.apache.commons.lang3.StringUtils;

public class StringMethods {
    public static void main(String[] args) {
        String s = "Some String";
        String a = "Some String";
        String c=" not trimmed ";
        System.out.println(StringUtils.startsWithIgnoreCase(s, a));
        System.out.println(StringUtils.containsIgnoreCase(s,a));
        System.out.println(c.trim());
    }
}
