package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class DisappearingElementsPage extends BasePage {

    @Step("Ищем 5 элементов с {maxAttempts} попытками")
    public void findFiveElementsWithAttempts(int maxAttempts) {
        for (int attempts = 0; attempts < maxAttempts; attempts++) {
            ElementsCollection elements = $$("ul li");

            System.out.println("Attempt " + (attempts + 1) + ": Found " + elements.size() + " elements.");

            if (elements.size() == 5) {
                return;
            }
            refreshPage();
        }
        throw new AssertionError("Failed to find 5 elements after " + maxAttempts + " attempts.");
    }
}