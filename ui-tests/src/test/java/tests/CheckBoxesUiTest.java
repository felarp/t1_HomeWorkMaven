package tests;


import io.qameta.allure.Description;
import pages.CheckBoxesPage;
import pages.MainPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class CheckBoxesUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    CheckBoxesPage checkBoxesPage = new CheckBoxesPage();

    @ParameterizedTest
    @CsvSource({
            "2, 1",
    })
    @Description("Проверка нажатия на чекбоксы в разном порядке и вывод их состояния.")
    public void checkboxesTest(int firstCheckbox, int secondCheckbox) {

        mainPage.goToPage("checkboxes");

        checkBoxesPage.toggleCheckboxes(firstCheckbox, secondCheckbox);
    }
}








