package pages;

import com.codeborne.selenide.ElementsCollection;
import java.util.Random;
import static com.codeborne.selenide.Selenide.*;

public class AddRemoveElementsPage extends BasePage {
    Random random = new Random();

    public void clickAddElementButton (int times) {
        for (int i = 0; i < times; i++) {
            $("button[onclick='addElement()']").click();
            System.out.println($$(".added-manually").get(i).getText());
        }
    }

    public void deleteElements(int times) {
        for (int i = 0; i < times; i++) {
            ElementsCollection buttons = $$(".added-manually");

            if (buttons.size() > 0) {
                int randomIndex = random.nextInt(buttons.size());
                buttons.get(randomIndex).click();
            } else {
                break;
            }

            int remaining = $$(".added-manually").size();
            System.out.println("Remaining Delete buttons: " + remaining);

            $$(".added-manually").forEach(button -> System.out.println(button.getText()));
        }
    }
}
