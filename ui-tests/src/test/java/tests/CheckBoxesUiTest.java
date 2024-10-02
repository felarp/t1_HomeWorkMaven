package tests;

import enums.Urls;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.CheckBoxesPage;
import pages.MainPage;

public class CheckBoxesUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    CheckBoxesPage checkBoxesPage = new CheckBoxesPage();

    @Test
    @Description("Тест на проверку и вывод состояния чекбоксов на странице чекбоксов.")
    public void checkboxesTest() {

        openBrowser(Urls.MAINPAGE.getUrl());

        mainPage.goToPage("checkboxes");
        checkBoxesPage.chooseAndPrintCheckboxes();



    }
}
