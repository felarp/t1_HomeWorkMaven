package pages;

import assertions.CommonAssertion;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;


public class DisappearingElementsPage extends BasePage {

    @Step("Проверяем наличие 5 элементов в списке")
    public void verifyFiveElements() {
        ElementsCollection elements = $$("ul li");
        System.out.println("Found " + elements.size() + " elements.");

        CommonAssertion.assertTrue(elements.size() == 5, "Expected 5 elements, but found: " + elements.size());
    }
}

