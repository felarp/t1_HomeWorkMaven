package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class DropdownPage extends BasePage {

    private final SelenideElement optionField = $x("//select[@id = 'dropdown']");

    public void selectFirstOption() {
        optionField.selectOption(1);
        printSelectedOptionText();

    }

    public void selectSecondOption() {
        optionField.selectOption(2);
        printSelectedOptionText();
    }

    private void printSelectedOptionText() {
        String selectedOption = optionField.getSelectedOptionText();
        System.out.println("Selected option: " + selectedOption);
    }
}
