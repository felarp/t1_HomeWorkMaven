package tests;

import enums.Urls;
import org.junit.jupiter.api.Test;
import pages.AddRemoveElementsPage;
import pages.MainPage;

public class AddRemoveElementsUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage();


    @Test

    public void testAddAndRemoveElements() {
        openBrowser(Urls.MAINPAGE.getUrl());
        mainPage.goToPage("add_remove_elements/");
        addRemoveElementsPage.clickAddElementButton(5);
        addRemoveElementsPage.deleteElements(3);
    }
}
