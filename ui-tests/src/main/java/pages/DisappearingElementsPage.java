package pages;


import com.codeborne.selenide.SelenideElement;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class DisappearingElementsPage extends BasePage {

    public List<SelenideElement> getElements() {
        return $$("ul li").stream().collect(Collectors.toList());
    }

    public void refreshPage() {
        refresh();
    }

    public void findFiveElementsWithAttempts(int maxAttempts) {
        for (int attempts = 0; attempts < maxAttempts; attempts++) {
            List<SelenideElement> elements = getElements();

            System.out.println("Attempt " + (attempts + 1) + ": Found " + elements.size() + " elements.");

            if (elements.size() == 5) {
                return;
            }
            refreshPage();
        }
        throw new AssertionError("Failed to find 5 elements after " + maxAttempts + " attempts.");
    }
}