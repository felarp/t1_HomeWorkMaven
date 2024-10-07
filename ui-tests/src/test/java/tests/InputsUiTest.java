package tests;

import enums.Urls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import pages.InputsPage;
import pages.MainPage;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.TestFactory;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class InputsUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    InputsPage inputsPage = new InputsPage();
    Random random = new Random();

    @TestFactory
    @DisplayName("Параметризованный тест ввода значений")
    Stream<DynamicTest> testInputValues() {
        openBrowser(Urls.MAINPAGE.getUrl());
        mainPage.goToPage("inputs");

        List<String> invalidInputs = List.of(
                "abc", "!@#", " 123", "123 ", "12.34", "   ", "abc123"
        );

        Stream<DynamicTest> randomTests = randomValuesTest(5);
        Stream<DynamicTest> predefinedTests = invalidInputsTest(invalidInputs);

        return Stream.concat(predefinedTests, randomTests);
    }

    private Stream<DynamicTest> randomValuesTest(int count) {
        return Stream.generate(() -> {
            int randomInt = random.nextInt(1000);
            String randomNumber = String.valueOf(randomInt);
            return DynamicTest.dynamicTest("Случайный ввод: " + randomNumber, () -> {
                inputsPage.enterValue(randomNumber);
                assertEquals(randomNumber, inputsPage.getInputValue());
            });
        }).limit(count);
    }

    private Stream<DynamicTest> invalidInputsTest(List<String> invalidInputs) {
        return invalidInputs.stream()
                .map(input -> DynamicTest.dynamicTest(
                        "Ввод: " + input,
                        () -> assertFalse(inputsPage.checkInput(input))
                ));
    }
}




