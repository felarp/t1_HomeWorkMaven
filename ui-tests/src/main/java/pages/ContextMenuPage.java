package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.qameta.allure.Step;


public class ContextMenuPage extends BasePage {

    private final SelenideElement contextBox = $("#hot-spot");

    @Step("Клик правой кнопкой мыши на области")
    public ContextMenuPage rightClickContextMenu() {
        actions().contextClick(contextBox).perform();
        return this;
    }

    @Step("Получение текста из JS Alert")
    public String getAlertText() {
        return switchTo().alert().getText();
    }

    @Step("Принятие JS Alert")
    public void acceptAlert() {
        switchTo().alert().accept();
    }

    @Step("Проверка текста в JS Alert")
    public ContextMenuPage verifyAlertText(String expectedText) {
        String actualText = getAlertText();
        assertEquals(expectedText, actualText, "Текст JS Alert не соответствует ожидаемому.");
        return this;
    }
    @Step("Проверка и принятие JS Alert")
    public ContextMenuPage acceptAndVerifyAlert(String expectedText) {
        verifyAlertText(expectedText);
        acceptAlert();
        return this;
    }
}



