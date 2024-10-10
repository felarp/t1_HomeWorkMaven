package assertions;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;




public class CommonAssertion  {

    @Step("Проверяем что значения {actual} и {expected} не равны")
    public static void assertNotEquals(Object actual, Object expected){
        Assertions.assertNotEquals(actual,expected, "Значения не равны");
    }
}
