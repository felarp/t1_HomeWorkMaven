package pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.$$x;

public class CheckBoxesPage extends BasePage {

    @Step("Проверяем каждый чекбокс на изменение состояний")
    public void listCheckboxesCheck(String order){
        List<SelenideElement> listCheckboxes = $$x("//form[@id='checkboxes']/input")
                .stream().collect(Collectors.toList());
        switch (order) {
            case "first" -> {
                listCheckboxes.forEach(this::checkboxChecked);
            }
            case "last" -> {
                Collections.reverse(listCheckboxes);
                listCheckboxes.forEach(this::checkboxChecked);
            }
        }

    }

    @Step("Проверяем состояние чекбокса")
    public void checkboxChecked(SelenideElement checkbox) {

        if (checkbox.isSelected()) {
            checkbox.click();
            checkbox.shouldNot(checked);
        } else {
            checkbox.click();
            checkbox.should(checked);
        }
    }
}

















