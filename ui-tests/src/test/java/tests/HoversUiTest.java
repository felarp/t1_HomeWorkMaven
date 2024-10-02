package tests;

import enums.Urls;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.HoversPage;
import pages.MainPage;

public class HoversUiTest extends BaseTest{

    MainPage mainPage = new MainPage();
    HoversPage hoversPage = new HoversPage();

    @Test
    @Description("Тест для наведения на изображения и проверки подписей на странице наведения курсора.")
    public void hoverOverImagesTest() {

        openBrowser(Urls.MAINPAGE.getUrl());
        mainPage.goToPage("hovers");
        hoversPage.hoverOverImagesAndPrintCaptions();

    }
}
