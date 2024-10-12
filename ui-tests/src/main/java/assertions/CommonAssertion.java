package assertions;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;


public class CommonAssertion {

    @Step("Проверяем что значения {actual} и {expected} не равны")
    public static void assertNotEquals(Object actual, Object expected) {
        Assertions.assertNotEquals(actual, expected, "Значения не равны");
    }

    @Step("Проверяем что значения {actual} и {expected}  равны")
    public static void assertEquals(Object actual, Object expected, String message) {
        Assertions.assertEquals(expected, actual, message);
    }

    @Step("Проверяем, что текст содержит ожидаемое сообщение {expectedMessage}")
    public static void assertMessageContains(String actualMessage, String expectedMessage) {
        Assertions.assertTrue(actualMessage.contains(expectedMessage), "Ожидалось сообщение: "
                + expectedMessage + ", но получено: " + actualMessage);
    }

    @Step("Проверяем что значения {expression} истинно")
    public static void assertTrue(boolean expression, String message) {
        Assertions.assertTrue(expression, message);
    }

}

