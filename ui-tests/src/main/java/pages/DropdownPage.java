package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownPage extends BasePage {

    private final SelenideElement optionField = $x("//select[@id='dropdown']");

    @Step("Выбираем первый вариант")
    public void selectFirstOption() {
        optionField.selectOption(1);
        assertSelectedOptionText("Option 1");
    }

    @Step("Выбираем второй вариант")
    public void selectSecondOption() {
        optionField.selectOption(2);
        assertSelectedOptionText("Option 2");
    }

    @Step("Выводим текст выбранного варианта и проверяем его")
    private void assertSelectedOptionText(String expectedText) {

        String actualText = optionField.getSelectedOption().getText();

        System.out.println("Selected option: " + actualText);
        assertEquals(expectedText, actualText, "Выбранная опция не соответствует ожидаемой: " + expectedText + " вместо " + actualText);
    }
}



