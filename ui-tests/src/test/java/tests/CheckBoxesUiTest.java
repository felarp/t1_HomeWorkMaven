package tests;

import enums.Urls;
import org.junit.jupiter.api.Test;
import pages.CheckBoxesPage;
import pages.MainPage;

public class CheckBoxesUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    CheckBoxesPage checkBoxesPage = new CheckBoxesPage();

    @Test

    public void testCheckboxes() {

        openBrowser(Urls.MAINPAGE.getUrl());

        mainPage.goToCheckboxesPage();
        checkBoxesPage.chooseCheckboxesAndPrintStates();

//        checkBoxesPage.checkFirstCheckbox();
//        checkBoxesPage.uncheckSecondCheckbox();
//
//        checkBoxesPage.printFirstCheckboxState();
//        checkBoxesPage.printSecondCheckboxState();
    }
}
