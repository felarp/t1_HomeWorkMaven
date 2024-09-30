package tests;

import enums.Urls;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.NotificationMessagePage;

public class NotificationMessageUiTest extends BaseTest{

    MainPage mainPage = new MainPage();
    NotificationMessagePage notificationMessagePage = new NotificationMessagePage();

    @Test

    public void notificationMessageTest() {
        openBrowser(Urls.MAINPAGE.getUrl());
        mainPage.goToPage("notification_message");

        String expectedMessage = "Action successful";
        notificationMessagePage.clickUntilSuccess(expectedMessage);

    }


}
