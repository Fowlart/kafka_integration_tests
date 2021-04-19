package rest;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Date;

public class Requests {
    public static void main(String[] args) {
        int counter = 0;
        while (counter < 5000) {

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("https://prod-z1-fconnect.mckesson.com/mckessonstorefront/receiving/containers")
                    .method("GET", null)
                    .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"89\", \"Chromium\";v=\"89\", \";Not A Brand\";v=\"99\"")
                    .addHeader("Accept", "application/json, text/plain, */*")
                    .addHeader("X-CSRFToken", "aba1fc90-383a-31a0-99fb-eba457e17dff")
                    .addHeader("sec-ch-ua-mobile", "?0")
                    .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36")
                    .addHeader("x-dtpc", "5$30287890_704h8vMCGHKIMKBJADUCEFVHAHVBRLHIPPSCWP-0e13")
                    .addHeader("Cookie", "dtCookie=v_4_srv_5_sn_C4E56AD16DB5017A85E949ECA939B180_perc_100000_ol_0_mul_1_app-3A5958a1e6dc18563d_1_rcs-3Acss_0; incap_ses_323_1846644=tNhXDPSBwW6acZ0cpZ6DBMs7dGAAAAAAyzmj+hMTipzkcD805eWvhA==; visid_incap_1784591=xuMMXiUeRNyDHwS7x09tVKWscGAAAAAAQUIPAAAAAAA6hR2G49TPfvSpBBjypjJI; visid_incap_1846644=nwqTnxofSCOk4K0H/8TZkS2mcGAAAAAAQUIPAAAAAACzsZKV5V68qLK5s2mSkRUQ; BIGipServerprod-z1-fconnect.mckesson.com_9005=757862666.11555.0000; JSESSIONID=23C62670663606E7B59D4AA308C8331E.frontoffice_5; PORTAL_USER=ITEtest2; acceleratorSecureGUID=9dcd94a03b9b6742eebffb46d6c3a54f1aa2273b; iamSessionId=AQIC5wM2LY4Sfcw-4LqrLafu4n2HaHb9WlutrX6_uUQIYSM.*AAJTSQACMDIAAlNLABMxMTQzODExNDI1MTMxMzU2MTE2AAJTMQACMDM.*; sessionExpirationInterval=14400")
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