package pages;

import com.codeborne.selenide.SelenideElement;


public class BasePage {

    public void assertCheckboxState(SelenideElement checkbox, boolean expectedState, String checkboxName) {

        boolean actualState = checkbox.isSelected();
        System.out.println(checkboxName + " is checked: " + actualState);
        assert (actualState == expectedState) : checkboxName + " expected state: " + expectedState;
    }


}



