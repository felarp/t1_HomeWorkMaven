package pages;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class InfiniteScrollPage extends BasePage {

    @Step("Прокрутка страницы вниз до тех пор, пока текст '{text}' не станет видимым.")
    public void scrollUntilTextIsVisible(String text) {
        SelenideElement textElement;

        while (true) {
            textElement = getTextElement(text);

            if (textElement.exists() && textElement.isDisplayed()) {
                break;
            }
            actions().sendKeys(Keys.PAGE_DOWN).perform();

            sleep(500);
        }
    }
    @Step("Поиск элемента с текстом '{text}' на странице.")
    public SelenideElement getTextElement(String text) {
        return $(By.xpath("//*[contains(text(),'" + text + "') and ancestor::div[contains(@class,'jscroll-inner')]]"));
    }

    @Step("Проверка, что текст '{text}' отображается на странице.")
    public void verifyTextIsDisplayed(String text) {
        SelenideElement textElement = getTextElement(text);
        assertTrue(textElement.isDisplayed(), "Текст '" + text + "' не отображается.");
    }
}






