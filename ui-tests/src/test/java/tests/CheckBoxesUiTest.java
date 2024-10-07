package tests;

import enums.Urls;
import io.qameta.allure.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.CheckBoxesPage;
import pages.MainPage;

public class CheckBoxesUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    CheckBoxesPage checkBoxesPage = new CheckBoxesPage();

    @ParameterizedTest
    @CsvSource({
            "checkbox1, checkbox2",
            "checkbox2, checkbox1"
    })
    @Description("Параметризированный тест для проверки состояния чекбоксов")
    public void checkboxesTest(String firstCheckbox, String secondCheckbox) {
        openBrowser(Urls.MAINPAGE.getUrl());

        mainPage.goToPage("checkboxes");

        checkBoxesPage.clickAndCheckState(firstCheckbox);

        checkBoxesPage.clickAndCheckState(secondCheckbox);


    }
}


