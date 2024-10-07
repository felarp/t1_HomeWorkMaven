package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import java.util.Random;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddRemoveElementsPage extends BasePage {
    Random random = new Random();

    @Step("Кликаем по кнопке 'Add Element', делая это {times} раз")
    public void clickAddElementButtonAndVerify(int times) {
        for (int i = 0; i < times; i++) {
            $("button[onclick='addElement()']").click();
        }

        int actualCount = $$(".added-manually").size();
        assertEquals(times, actualCount, "Ожидалось " + times + " элементов, но получено " + actualCount);
    }

    @Step("Удаляем элементы, делая это {times} раз")
    public void deleteElementsAndVerify(int times) {
        ElementsCollection buttons = $$(".added-manually");
        int initialSize = buttons.size();

        for (int i = 0; i < times; i++) {
            if (!buttons.isEmpty()) {
                int randomIndex = random.nextInt(buttons.size());
                buttons.get(randomIndex).click();
                buttons = $$(".added-manually");
            } else {
                break;
            }
        }

        int expectedRemaining = Math.max(0, initialSize - times);
        int remainingElements = buttons.size();
        assertEquals(expectedRemaining, remainingElements, "Ожидалось " + expectedRemaining + " оставшихся элементов, но получено " + remainingElements);
    }
}

