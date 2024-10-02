package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class DropdownPage extends BasePage {

    private final SelenideElement optionField = $x("//select[@id = 'dropdown']");

    @Step("Выбираем первый вариант")
    public void selectFirstOption() {
        optionField.selectOption(1);
        printSelectedOptionText();

    }

    @Step("Выбираем второй вариант")
    public void selectSecondOption() {
        optionField.selectOption(2);
        printSelectedOptionText();
    }

    @Step("Выводим текст выбранного варианта")
    private void printSelectedOptionText() {
        System.out.println("Selected option: " + optionField.getSelectedOptionText());
    }
}
