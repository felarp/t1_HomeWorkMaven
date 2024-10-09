package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.Keys;


public class KeyPressesPage extends BasePage {

    private final SelenideElement inputField = $("#target");
    private final SelenideElement resultText = $("#result");


    @Step("Нажатие клавиши '{key}' и проверка отображаемого текста")
    public void pressKeyAndCheck(String key, String expectedText) {
        inputField.click();

        inputField.clear();

        switch (key.toUpperCase()) {
            case "CONTROL":
                actions().sendKeys(Keys.CONTROL).perform();
                break;
            case "ALT":
                actions().sendKeys(Keys.ALT).perform();
                break;
            case "TAB":
                actions().sendKeys(Keys.TAB).perform();
                break;
            case "ENTER":
                actions().sendKeys(Keys.ENTER).perform();
                break;
            default:

                actions().sendKeys(inputField, key).perform();
                break;
        }

        resultText.shouldHave(text(expectedText));
    }
}









