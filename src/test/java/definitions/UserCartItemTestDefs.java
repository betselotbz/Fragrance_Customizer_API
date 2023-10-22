package definitions;

import com.example.fragrance_customizer_api.FragranceCustomizerApiApplication;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FragranceCustomizerApiApplication.class)
public class UserCartItemTestDefs {

    private final Logger logger = LoggerFactory.getLogger(UserCartItemTestDefs.class);
    private static final String Base_URL = "http://localhost:";

    @LocalServerPort
    String port;
    /**
     * Retrieves a JWT (JSON Web Token) key by sending a POST request to the authentication endpoint.
     * This method sets up the necessary HTTP request with user credentials and sends it to the
     * authentication endpoint to obtain a JWT key for user authentication.
     *
     * @return The JWT key (token) received from the authentication response.
     * @throws JSONException If there is an issue with JSON processing.
     */

    public static String getJWTKey(String port) throws JSONException {


    }


    @Given("a user with ID {int} exists")
    public void aUserWithIDExists(int userId) {


    }
}
