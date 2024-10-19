package pages;

import assertions.PageAssert;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class CheckBoxesPage extends BasePage {
    private final PageAssert pageAssert = new PageAssert();

    @Step("Проверяем каждый чекбокс на изменение состояний")
    public void listCheckboxesCheck(String order){
        List<SelenideElement> listCheckboxes = $$x("//form[@id='checkboxes']/input")
                .stream().collect(Collectors.toList());
        switch (order) {
            case "first" -> {
                listCheckboxes.forEach(this::toggleAndCheckCheckbox);
            }
            case "last" -> {
                Collections.reverse(listCheckboxes);
                listCheckboxes.forEach(this::toggleAndCheckCheckbox);
            }
        }

    }

    @Step("Проверяем состояние чекбокса")
    public void toggleAndCheckCheckbox(SelenideElement checkbox) {
        boolean isChecked = checkbox.isSelected();
        checkbox.click();
        pageAssert.assertCheckboxState(checkbox, !isChecked);
    }
}

















