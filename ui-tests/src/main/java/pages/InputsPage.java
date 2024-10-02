package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class InputsPage extends BasePage {


    private final SelenideElement inputField = $x ("//input[@type ='number']");

    @Step("Вводим случайное число: {number}")
    public void enterRandomNumber (int number) {
        inputField.setValue(String.valueOf(number));
    }

    @Step("Получаем значение из поля ввода")
    public String getInputValue() {
    return inputField.getValue();

    }
}
