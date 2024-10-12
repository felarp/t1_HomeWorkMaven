package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.RepeatedTest;
import pages.MainPage;
import pages.NotificationMessagePage;

public class NotificationMessageUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    NotificationMessagePage notificationMessagePage = new NotificationMessagePage();

    @RepeatedTest(5)
    @Description("Тест для проверки сообщения уведомления и его успешного статуса.")
    public void notificationMessageTest() {

        mainPage.goToPage("notification_message");
        String expectedMessage = "Action successful";
        notificationMessagePage.clickUntilSuccess(expectedMessage);
    }
}

