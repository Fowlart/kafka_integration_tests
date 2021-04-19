import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ReceivingConnectionTests {

    public static void main(String[] args) throws Exception {

        String receivingUat = "https://cbs-mm-receiving-dev.app.dev-west.paas.mckesson.com/v1/receiving/containers/items?query=1&customerId=qaepam08";
        String receivingLocal = "http://localhost:8090/v1/receiving/containers/items?query=1&customerId=qaepam08";

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(receivingLocal)
                .method("GET", null)
                .addHeader("Authentication", "mckesson1234")
                .build();

        Long start =System.currentTimeMillis();
        Response response = client.newCall(request).execute();
        System.out.println(">>> milis: "+(System.currentTimeMillis()-start));
        start = System.currentTimeMillis();
        String s = response.body().string();
        System.out.println(">>> milis: "+(System.currentTimeMillis()-start));
    }
}
