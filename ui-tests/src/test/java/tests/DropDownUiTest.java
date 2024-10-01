package tests;

import enums.Urls;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;
import pages.MainPage;


public class DropDownUiTest extends BaseTest{

    MainPage mainPage = new MainPage();
    DropdownPage dropdownPage = new DropdownPage();

    @Test
    public void dropdownOptionsTest() {
        openBrowser(Urls.MAINPAGE.getUrl());
        mainPage.goToPage("dropdown");
        dropdownPage.selectFirstOption();
        dropdownPage.selectSecondOption();
    }

}
