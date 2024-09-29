package pages;
import static org.junit.Assert.assertEquals;

import com.codeborne.selenide.SelenideElement;


public class BasePage {

    public void assertCheckboxState(SelenideElement checkbox, boolean expectedState, String checkboxName) {

        boolean actualState = checkbox.isSelected();
        System.out.println(checkboxName + " is checked: " + actualState);
        assert (actualState == expectedState) : checkboxName + " expected state: " + expectedState;
    }

    public void assertElementCount(int expectedCount, int actualCount, int attempts) {
        System.out.println("Expected count: " + expectedCount + ", Actual count: : " + actualCount + "Attempts: " + attempts);

        assertEquals ("Не удалось найти " + expectedCount + " элементов за " + attempts + " попыток",
                expectedCount, actualCount);

        System.out.println("Assertion passed");
    }
}



