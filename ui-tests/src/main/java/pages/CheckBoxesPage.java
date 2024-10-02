package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class CheckBoxesPage extends BasePage {

    private final SelenideElement checkbox1 = $x("//form[@id='checkboxes']/input[1]");
    private final SelenideElement checkbox2 = $x("//form[@id='checkboxes']/input[2]");

    @Step("Выбираем чекбоксы и проверяем их состояния")
    public void chooseAndPrintCheckboxes() {
        checkbox1.click();
        printCheckBoxState(checkbox1, "Checkbox 1");
        checkbox2.click();
        printCheckBoxState(checkbox2, "Checkbox 2");

    }
    @Step("Выводим на печать состояние чекбокса {checkboxName}")
    public void printCheckBoxState(SelenideElement checkbox, String checkboxName) {
        boolean actualState = checkbox.isSelected();
        System.out.println(checkboxName + " is checked: " + actualState);

    }

}