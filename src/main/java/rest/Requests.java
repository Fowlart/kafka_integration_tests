package rest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class Requests {
    public static void main(String[] args) throws IOException, UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("http://localhost:9001/mckessonwebservicestest/MckWebServices/Hybris/ECC/ELAPricingZone1")
                .header("Content-Type", "application/json")
                .body("{\"CatalogSearchRequest\":{\"UniqueTransactionId\":\"0592020040626NGO1\",\"CustomerAccountNumber\":\"013405\",\r\n\"Items\": [{\"ItemNumber\":\"1619089\"},{\"ItemNumber\":\"1921345\"},{\"ItemNumber\":\"2012060\"},{\"ItemNumber\":\"1976737\"},{\"ItemNumber\":\"3669769\"},{\"ItemNumber\":\"1924851\"}],\"EnterpriseTrackingId\":\"9904adcd-f559-4be7-a1ee-5a91e34ca3bd\"}}")
                .asString();

        System.out.println(response.getBody());

    }
}

