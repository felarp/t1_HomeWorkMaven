package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DynamicTest;
import pages.InputsPage;
import pages.MainPage;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.TestFactory;
import java.util.stream.Stream;

public class InputsUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    InputsPage inputsPage = new InputsPage();
    Random random = new Random();

    @TestFactory
    @Description("Повторяем тест 10 раз с различными случайными значениями и выполняем негативные тесты.")
    public Stream<DynamicTest> inputsTestRepeated() {

        mainPage.goToPage("inputs");


        List<Integer> randomNumbers = random.ints(10, 1, 10001).boxed().toList();


        Stream<DynamicTest> positiveTests = randomNumbers.stream()
                .map(number -> DynamicTest.dynamicTest(
                        "Тест с числом: " + number,
                        () -> inputsPage.testNumber(number)
                ));


        Stream<DynamicTest> negativeTests = Stream.of(
                DynamicTest.dynamicTest("Попытка ввести латинские буквы", () -> inputsPage.testInvalidInput("abcDEF", 0)),
                DynamicTest.dynamicTest("Попытка ввести спецсимволы", () -> inputsPage.testInvalidInput("!@#$%^&*()", 0)),
                DynamicTest.dynamicTest("Попытка ввести пробелы до и после числа", () -> inputsPage.testInvalidInput("   12345   ", 12345))
        );

        return Stream.concat(positiveTests, negativeTests);
    }
}










