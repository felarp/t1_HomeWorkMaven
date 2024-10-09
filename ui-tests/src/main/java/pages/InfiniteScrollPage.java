package pages;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;



public class InfiniteScrollPage extends BasePage {

    @Step("Прокрутка страницы до тех пор, пока текст '{text}' не станет видимым.")
    public void scrollUntilTextIsVisible(String text) {
        // Получаем элемент текста
        SelenideElement textElement = getTextElement(text);


        while (!textElement.isDisplayed()) {
            actions().moveToElement(textElement).perform();
            sleep(500);

            textElement = getTextElement(text);
        }
    }

    public SelenideElement getTextElement(String text) {
        return $(By.xpath("//*[contains(text(),'" + text + "')]"));
    }

    @Step("Проверка, что текст '{text}' отображается на странице.")
    public void verifyTextIsDisplayed(String text) {
        SelenideElement textElement = getTextElement(text);
        assertTrue(textElement.isDisplayed(), "Текст '" + text + "' не отображается.");
    }
}



