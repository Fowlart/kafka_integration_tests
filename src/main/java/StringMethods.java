import org.apache.commons.lang3.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.Arrays;
import static org.apache.commons.lang.StringUtils.isNotBlank;

public class StringMethods {
    public static void main(String[] args) throws MalformedURLException {
        String urlForProxy = "http://localhost:8080";
        StringBuffer s = new StringBuffer("https://localhost:9002/mckessonstorefront/mobile");


        String transformedUrl =urlForProxy+"/";
        System.out.println(transformedUrl);

        isNotBlank(transformedUrl);



    }
}
