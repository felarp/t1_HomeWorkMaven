package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.util.Random;
import static com.codeborne.selenide.Selenide.*;

public class AddRemoveElementsPage extends BasePage {
    Random random = new Random();

    @Step("Кликаем по кнопке 'Add Element', делая это {times} раз")
    public void clickAddElementButton (int times) {
        for (int i = 0; i < times; i++) {
            $("button[onclick='addElement()']").click();
            System.out.println($$(".added-manually").get(i).getText());
        }
    }

    @Step("Удаляем элементы, делая это {times} раз")
    public void deleteElements(int times) {
        ElementsCollection buttons = $$(".added-manually");
        for (int i = 0; i < times; i++) {

            if (!buttons.isEmpty()) {
                int randomIndex = random.nextInt(buttons.size());
                buttons.get(randomIndex).click();
            } else {
                break;
            }

            System.out.println("Remaining Delete buttons: " + $$(".added-manually").size());

            buttons.forEach(button -> System.out.println(button.getText()));
        }
    }
}
