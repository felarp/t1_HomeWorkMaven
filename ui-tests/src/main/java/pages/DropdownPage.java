package pages;

import assertions.CommonAssertions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$x;

public class DropdownPage extends BasePage {

    private final SelenideElement optionField = $x("//select[@id='dropdown']");

    @Step("Выбираем первый вариант")
    public void selectFirstOption() {
        optionField.selectOption(1);
        CommonAssertions.assertEquals(optionField.getSelectedOption().getText(), "Option 1",
                "Выбранная опция не соответствует ожидаемой");
    }

    @Step("Выбираем второй вариант")
    public void selectSecondOption() {
        optionField.selectOption(2);
       CommonAssertions.assertEquals(optionField.getSelectedOption().getText(),"Option 2",
                "Выбранная опция не соответствует ожидаемой");
    }
}



