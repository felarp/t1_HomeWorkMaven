
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import providers.RestApiBuilder;

public class BaseApiTest {

    protected static RestApiBuilder restApiBuilder = new RestApiBuilder();


    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://9b142cdd34e.vps.myjino.ru:49268";
        RestAssured.basePath = "";
        RestApiBuilder.filters();
    }
}
