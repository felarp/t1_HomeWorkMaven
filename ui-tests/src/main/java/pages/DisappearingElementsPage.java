package pages;

import com.codeborne.selenide.ElementsCollection;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.refresh;

public class DisappearingElementsPage extends BasePage {


    public List<ElementsCollection> getElements() {
        return Collections.singletonList($$x("//li/a"));
    }
        public void refreshPage() {
        refresh();
        }

        public boolean findFiveElementsWithAttempts (int maxAttempts) {
        for(int attempts = 0; attempts< maxAttempts; attempts ++) {
            List<ElementsCollection> elements = getElements();

            if (elements.size() == 5) {
                assertElementCount(5, elements.size(), attempts + 1);
                return true;
            }
            refreshPage();
        }
        assertElementCount(5,0,maxAttempts);
        return false;
        }
}
