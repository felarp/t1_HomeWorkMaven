package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.Keys;


public class KeyPressesPage extends BasePage {

    private SelenideElement inputField = $("#target");
    private SelenideElement resultText = $("#result");

    @Step("Открытие страницы Key Presses")
    public void openPage() {
        open("/key_presses");
    }

    @Step("Нажатие клавиши '{key}' и проверка отображаемого текста")
    public void pressKeyAndCheck(String key, String expectedText) {

        inputField.click();

        inputField.clear();

        if (key.equals("CONTROL") || key.equals("ALT") || key.equals("TAB")) {
            actions().keyDown(key.equals("CONTROL") ? Keys.CONTROL :
                            key.equals("ALT") ? Keys.ALT :
                                    Keys.TAB)
                    .perform();

            actions().sendKeys(inputField, Keys.ENTER).perform();

            resultText.shouldHave(text(expectedText));
            actions().keyUp(key.equals("CONTROL") ? Keys.CONTROL :
                            key.equals("ALT") ? Keys.ALT :
                                    Keys.TAB)
                    .perform();
        } else {

            actions().sendKeys(inputField, key).perform();

            actions().sendKeys(inputField, Keys.ENTER).perform();

            resultText.shouldHave(text(expectedText));
        }
    }
}







