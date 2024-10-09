package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckBoxesPage extends BasePage {

    private final SelenideElement checkbox1 = $x("//form[@id='checkboxes']/input[1]");
    private final SelenideElement checkbox2 = $x("//form[@id='checkboxes']/input[2]");

    @Step("Снимаем выделение с чекбокса {checkboxToUncheck} и выбираем чекбокс {checkboxToCheck}")
    public void toggleCheckboxes(int checkboxToUncheck, int checkboxToCheck) {
        SelenideElement checkboxToUncheckElement = getCheckboxElement(checkboxToUncheck);
        SelenideElement checkboxToCheckElement = getCheckboxElement(checkboxToCheck);

        checkboxToUncheckElement.click();
        assertCheckBoxState(checkboxToUncheckElement, "Checkbox " + checkboxToUncheck, false);

        checkboxToCheckElement.click();
        assertCheckBoxState(checkboxToCheckElement, "Checkbox " + checkboxToCheck, true);
    }

    @Step("Получаем элемент чекбокса по номеру")
    public SelenideElement getCheckboxElement(int checkboxNumber) {
        if (checkboxNumber == 1) {
            return checkbox1;
        } else if (checkboxNumber == 2) {
            return checkbox2;
        } else {
            throw new IllegalArgumentException("Неверный номер чекбокса: " + checkboxNumber);
        }
    }

    @Step("Проверяем и выводим состояние чекбокса {checkboxName}")
    public void assertCheckBoxState(SelenideElement checkbox, String checkboxName, boolean shouldBeChecked) {
        boolean hasCheckedAttribute = checkbox.getAttribute("checked") != null;

        if (shouldBeChecked) {
            assertTrue(hasCheckedAttribute, checkboxName + " должен быть отмечен.");
        } else {
            assertFalse(hasCheckedAttribute, checkboxName + " не должен быть отмечен.");
        }

        System.out.println(checkboxName + " is checked: " + hasCheckedAttribute);
    }
}














