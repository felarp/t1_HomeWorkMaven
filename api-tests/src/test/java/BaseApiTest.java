
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import providers.RestApiBuilder;

public class BaseApiTest {

    protected static RestApiBuilder restApiBuilder = new RestApiBuilder();
    private static final ProjectConfig projectConfig = ConfigFactory.create((ProjectConfig.class));

    @BeforeAll
    public static void setUp() {

        RestAssured.baseURI = projectConfig.baseUrl() ;
        RestAssured.basePath = "";
        RestApiBuilder.filters();
    }
}
