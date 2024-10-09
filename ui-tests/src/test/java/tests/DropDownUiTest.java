package tests;

import enums.Urls;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;
import pages.MainPage;


public class DropDownUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    DropdownPage dropdownPage = new DropdownPage();

    @Test
    @Description("Тест для выбора опций в выпадающем списке на соответствующей странице.")
    public void dropdownOptionsTest() {

        mainPage.goToPage("dropdown");
        dropdownPage.selectFirstOption();
        dropdownPage.selectSecondOption();
    }
}

