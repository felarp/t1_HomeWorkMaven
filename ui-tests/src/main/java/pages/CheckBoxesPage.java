package pages;

import assertions.CommonAssertion;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class CheckBoxesPage extends BasePage {

    @Step("Проверить каждый чекбок на изменение состояний")
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

    @Step("Проверить состояние чекбокса")
    public void checkboxChecked(SelenideElement checkbox) {
       boolean defaultState = checkbox.has(Condition.attribute("checked"));
        checkbox.click();
        CommonAssertion.assertNotEquals(defaultState,checkbox.has(Condition.attribute("checked")));
    }
}

















