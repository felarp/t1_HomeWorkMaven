package assertions;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.checked;


public class PageAssert {

    public void assertCheckboxState(SelenideElement checkbox, boolean expectedState) {
        if (expectedState) {
            checkbox.shouldBe(checked);
        } else {
            checkbox.shouldNotBe(checked);
        }
    }

}

