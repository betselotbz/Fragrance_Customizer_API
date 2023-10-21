package definitions;

import com.example.fragrance_customizer_api.FragranceCustomizerApiApplication;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FragranceCustomizerApiApplication.class)
public class UserCartItemTestDefs {

    private final Logger logger = LoggerFactory.getLogger(UserCartItemTestDefs.class);
    private static final String Base_URL = "http://localhost:";

    @LocalServerPort
    String port;

    @Given("a user with ID {int} exists")
    public void aUserWithIDExists(int arg0) {
    }
}
