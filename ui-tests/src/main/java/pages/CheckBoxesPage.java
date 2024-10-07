package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckBoxesPage extends BasePage {

    private final SelenideElement checkbox1 = $x("//form[@id='checkboxes']/input[1]");
    private final SelenideElement checkbox2 = $x("//form[@id='checkboxes']/input[2]");

    @Step("Нажимаем на {checkboxName} и проверяем его состояние")
    public void clickAndCheckState(String checkboxName) {
        SelenideElement checkbox = getCheckbox(checkboxName);
        checkbox.click();

        String checkedAttribute = checkbox.getAttribute("checked");
        boolean actualState = "true".equals(checkedAttribute);

        System.out.println(checkboxName + " is checked: " + actualState);
        assertTrue(actualState, "Чекбокс " + checkboxName + " должен быть выбран после клика");
    }

    private SelenideElement getCheckbox(String checkboxName) {
        switch (checkboxName) {
            case "checkbox1":
                return checkbox1;
            case "checkbox2":
                return checkbox2;
            default:
                throw new IllegalArgumentException("Неверное имя чекбокса: " + checkboxName);
        }
    }
}



