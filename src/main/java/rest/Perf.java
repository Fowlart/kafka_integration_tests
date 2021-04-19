package rest;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Date;

public class Perf {
    public static void main(String[] args) {

        int counter = 0;

        while (counter < 5000) {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("https://prod-z1-fconnect.mckesson.com/mckessonstorefront/receiving/containers")
                    .method("GET", null)
                    .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99\"")
                    .addHeader("accept", "application/json, text/plain, */*")
                    .addHeader("x-csrftoken", "d725f456-03e7-3c32-af5b-04d2c595324a")
                    .addHeader("sec-ch-ua-mobile", "?0")
                    .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36")
                    .addHeader("x-dtpc", "5$26868486_743h8vCIVUAFAFHCSAMGKVHCVUEFDHKHFPVMWO-0e19")
                    .addHeader("Cookie", "dtCookie=v_4_srv_5_sn_8920C980BE491ABA486CE7E1B10AB548_perc_100000_ol_0_mul_1_app-3A5958a1e6dc18563d_1_rcs-3Acss_0; incap_ses_323_1846644=sfgEJVYjIB3aB5scpZ6DBLIxdGAAAAAAYF2fZZDIVP84pXWMMSywBw==; visid_incap_1784591=xuMMXiUeRNyDHwS7x09tVKWscGAAAAAAQUIPAAAAAAA6hR2G49TPfvSpBBjypjJI; visid_incap_1846644=nwqTnxofSCOk4K0H/8TZkS2mcGAAAAAAQUIPAAAAAACzsZKV5V68qLK5s2mSkRUQ; BIGipServerprod-z1-fconnect.mckesson.com_9005=757862666.11555.0000; JSESSIONID=DC74C9076DDC9F0A1F050F6B236805ED.frontoffice_5; PORTAL_USER=ITEtest2; ___utmvc=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; acceleratorSecureGUID=2b2c3af813bfcae4a0fba13080800cf4c03e629f; iamSessionId=AQIC5wM2LY4SfcwCGjwEuE6KLNuqPGNtbJsqO_1bqisgKek.*AAJTSQACMDIAAlNLABQtNzMzNTQwNDExMzQ1MDY3NDEyMwACUzEAAjAz*; sessionExpirationInterval=14400")
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
