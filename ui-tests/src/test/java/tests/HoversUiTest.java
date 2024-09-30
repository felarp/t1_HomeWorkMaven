package tests;

import enums.Urls;
import org.junit.jupiter.api.Test;
import pages.HoversPage;
import pages.MainPage;

public class HoversUiTest extends BaseTest{

    MainPage mainPage = new MainPage();
    HoversPage hoversPage = new HoversPage();

    @Test

    public void hoverOverImagesTest() {

        openBrowser(Urls.MAINPAGE.getUrl());
        mainPage.goToPage("hovers");
        hoversPage.hoverOverImagesAndPrintCaptions();

    }
}
