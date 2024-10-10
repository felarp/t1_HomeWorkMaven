package tests;

import pages.CheckBoxesPage;
import pages.MainPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;
import java.util.stream.Stream;

public class CheckBoxesUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    CheckBoxesPage checkBoxesPage = new CheckBoxesPage();

    @ParameterizedTest
    @MethodSource("checkboxOrderProvider")
    @DisplayName("Тест на проверку и вывод состояния чекбоксов на странице чекбоксов с разными порядками нажатия")
    public void checkboxesTest(String order) {

        mainPage.goToPage("checkboxes");

        if (order.equals("1-2")) {
            checkBoxesPage.chooseAndPrintCheckboxes();
        } else if (order.equals("2-1")) {
            checkBoxesPage.checkAndToggleCheckbox(checkBoxesPage.getCheckbox2(), "Checkbox 2");
            checkBoxesPage.checkAndToggleCheckbox(checkBoxesPage.getCheckbox1(), "Checkbox 1");
        }
    }

    private static Stream<String> checkboxOrderProvider() {
        return Stream.of("1-2", "2-1");
    }
}









