package rest;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Date;

public class UAT {

    public static void main(String[] args) {

        int counter = 0;

        while (counter < 5000) {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("https://uat-z1-fconnect.mckesson.com/mckessonstorefront/receiving/containers")
                    .method("GET", null)
                    .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99\"")
                    .addHeader("Accept", "application/json, text/plain, */*")
                    .addHeader("X-CSRFToken", "5d74ee82-c42c-34bb-bf84-f354b6de0e88")
                    .addHeader("sec-ch-ua-mobile", "?0")
                    .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36")
                    .addHeader("Cookie", "previous_login_timestamp=2021-04-12T05:12:11.053-07:00; visid_incap_1784591=xuMMXiUeRNyDHwS7x09tVKWscGAAAAAAQUIPAAAAAAA6hR2G49TPfvSpBBjypjJI; visid_incap_1846644=nwqTnxofSCOk4K0H/8TZkS2mcGAAAAAAQUIPAAAAAACzsZKV5V68qLK5s2mSkRUQ; BIGipServeruat-z1-fconnect.mckesson.com_9009=1360335114.12579.0000; JSESSIONID=07F70A5C8A18EBCBEF9301D33FCC3307.frontoffice_1; PORTAL_USER=uatcs62; acceleratorSecureGUID=110f28a7b80a7aacbaa54d3d0b307d75cf5b4849; iamSessionId=AQIC5wM2LY4SfczynAviIpDk0KtHvpNCiliOnKtwiXm4WzE.*AAJTSQACMDIAAlNLABM2MTk0NTM1MjQyNTEzNDkwNDg0AAJTMQACMDM.*; sessionExpirationInterval=7200")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                if (response.code()!=200){
                    System.out.println();
                    System.out.println("FAILED!!!");
                    System.out.println("Attempt number: "+counter+" at "+new Date().toString());
                    System.out.println("response code:"+response.code());
                    System.out.println();

                }
                response.close();
            } catch (IOException e) {
                System.out.println();
                System.out.println("FAILED!!!");
                System.out.println("Attempt number: "+counter+" at "+new Date().toString());
                System.out.println(e.getMessage());
                System.out.println();
            }
            counter++;
        }
        System.out.println("FINISHED");
    }

}
