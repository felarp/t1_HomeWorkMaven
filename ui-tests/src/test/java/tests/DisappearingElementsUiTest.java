package tests;


import enums.Urls;
import org.junit.jupiter.api.Test;
import pages.DisappearingElementsPage;

import pages.MainPage;

public class DisappearingElementsUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage();

    @Test

    public void disappearingElementsTest() {
        openBrowser(Urls.MAINPAGE.getUrl());
        mainPage.goToPage("disappearing_elements");
        disappearingElementsPage.findFiveElementsWithAttempts(10);

    }
}