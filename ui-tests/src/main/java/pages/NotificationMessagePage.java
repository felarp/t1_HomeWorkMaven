package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NotificationMessagePage extends BasePage {

    private final SelenideElement clickLink = $("#content > div > p > a");
    private final SelenideElement notification = $("#flash");



    public void clickUntilSuccess(String expectedMessage) {
        String actualMessage = "";
        while (!actualMessage.contains(expectedMessage)) {
            clickLink.click();
            actualMessage = notification.text().trim();
            System.out.println("Received Notification: " + actualMessage);
            if (!actualMessage.contains(expectedMessage)) {
                $$(".close").first().click();
            }
        }
    }
}
