import org.apache.commons.lang.StringUtils;

import java.net.MalformedURLException;

public class StringMethods {
    public static void main(String[] args) throws MalformedURLException {
        boolean isEmpPlusEmpEqEmp = StringUtils.isNotEmpty(StringUtils.EMPTY + StringUtils.EMPTY);
        System.out.println(isEmpPlusEmpEqEmp);
    }
}
