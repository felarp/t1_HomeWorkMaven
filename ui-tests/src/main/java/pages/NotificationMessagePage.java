package pages;

import assertions.CommonAssertion;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class NotificationMessagePage extends BasePage {

    private final SelenideElement clickLink = $("#content > div > p > a");
    private final SelenideElement notification = $("#flash");

    @Step("Кликаем до тех пор, пока не появится сообщение с текстом: {expectedMessage}")
    public void clickUntilSuccess(String expectedMessage) {
        clickLink.click();
        String actualMessage = notification.text().trim();
        System.out.println("Получено уведомление: " + actualMessage);
        CommonAssertion.assertMessageContains(actualMessage,expectedMessage);
    }
}





