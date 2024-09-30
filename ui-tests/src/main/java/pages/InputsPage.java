package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class InputsPage extends BasePage {


    private final SelenideElement inputField = $x ("//input[@type ='number']");

    public void enterRandomNumber (int number) {
        inputField.setValue(String.valueOf(number));
    }

    public String getInputValue() {
    return inputField.getValue();

    }
}
