import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BasicAuth {

    public static void main(String[] args) {

        String user = "receivingClient";
        String secret = "iAmReceiving1289";
        String testedPassword = "79c787f4c9a6e16676ae83a76a5b0387cbaf4208343e7e6d34df8f4caa33e4932812d91619f8a64c";

        Pbkdf2PasswordEncoder cryptPasswordEncoder = new Pbkdf2PasswordEncoder();
        String encryptPassword= cryptPasswordEncoder.encode(secret);
        System.out.println("for our settings: "+encryptPassword);
        String encodedString = Base64.getEncoder().encodeToString((user + ":" + secret).getBytes(StandardCharsets.UTF_8));
        System.out.println("Expected header name: Authorization");
        System.out.println("Expected header: "+"Basic " + encodedString);
        System.out.println("Is password match? "+cryptPasswordEncoder.matches(secret,testedPassword));
    }
}
