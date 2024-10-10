package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import static com.codeborne.selenide.Selenide.$x;

public class CheckBoxesPage extends BasePage {

    private final SelenideElement checkbox1 = $x("//form[@id='checkboxes']/input[1]");
    private final SelenideElement checkbox2 = $x("//form[@id='checkboxes']/input[2]");

    @Step("Выбираем чекбоксы и проверяем их состояния")
    public void chooseAndPrintCheckboxes() {
        checkAndToggleCheckbox(checkbox1, "Checkbox 1");
        checkAndToggleCheckbox(checkbox2, "Checkbox 2");
    }

    @Step("Проверяем состояние чекбокса и переключаем его")
    public void checkAndToggleCheckbox(SelenideElement checkbox, String checkboxName) {

        boolean previousState = "true".equals(checkbox.getAttribute("checked"));
        checkbox.click();
        boolean currentState = "true".equals(checkbox.getAttribute("checked"));
        printCheckBoxState(checkbox, checkboxName);
        Assertions.assertNotEquals(previousState, currentState, checkboxName + " state did not change as expected");
    }

    @Step("Выводим на печать состояние чекбокса {checkboxName}")
    public void printCheckBoxState(SelenideElement checkbox, String checkboxName) {
        boolean actualState = "true".equals(checkbox.getAttribute("checked"));
        System.out.println(checkboxName + " is checked: " + actualState);
    }

    public SelenideElement getCheckbox1() {
        return checkbox1;
    }

    public SelenideElement getCheckbox2() {
        return checkbox2;
    }
}
















