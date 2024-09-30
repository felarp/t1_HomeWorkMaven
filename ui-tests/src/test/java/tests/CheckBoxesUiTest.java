package tests;

import enums.Urls;
import org.junit.jupiter.api.Test;
import pages.CheckBoxesPage;
import pages.MainPage;

public class CheckBoxesUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    CheckBoxesPage checkBoxesPage = new CheckBoxesPage();

    @Test

    public void checkboxesTest() {

        openBrowser(Urls.MAINPAGE.getUrl());

        mainPage.goToPage("checkboxes");
        checkBoxesPage.chooseCheckboxesAndPrintStates();


    }
}
