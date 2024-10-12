package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;


public class KeyPressesPage extends BasePage {

    private final SelenideElement inputField = $("#target");
    private final SelenideElement resultText = $("#result");


    @Step("Нажатие клавиши '{key}' и проверка отображаемого текста")
    public void pressKeyAndCheck(String key) {
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

        Assertions.assertTrue(resultText.getText().contains(key), "Всплывающий текст не соответствует");
    }

    @Step("Проверка коллекции клавиш на нажатие")
    public void checkListKeys(String[] keys) {
        Arrays.stream(keys).forEach(this::pressKeyAndCheck);
    }
}









