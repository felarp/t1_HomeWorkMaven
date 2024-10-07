package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class InputsPage extends BasePage {

    private final SelenideElement inputField = $x("//input[@type='number']");

    @Step("Вводим значение: {input}")
    public void enterValue(String input) {
        inputField.clear();
        inputField.sendKeys(input);
    }

    @Step("Получаем значение из поля ввода")
    public String getInputValue() {
        return inputField.getValue();
    }

    @Step("Проверка введенного значения: {input}")
    public boolean checkInput(String input) {
        enterValue(input);
        String value = getInputValue();
        return input.trim().equals(value) || value.isEmpty();
    }
}




