package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import java.util.Random;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddRemoveElementsPage extends BasePage {
    Random random = new Random();
    private int expectedCount = 0;

    @Step("Кликаем по кнопке 'Add Element', делая это {times} раз")
    public void clickAddElementButton(int times) {
        for (int i = 0; i < times; i++) {
            $("button[onclick='addElement()']").click();
            expectedCount++;
        }
        verifyVisibleElementsCount(expectedCount); // Проверяем в конце добавления
    }

    @Step("Удаляем элементы, делая это {times} раз")
    public void deleteElements(int times) {
        for (int i = 0; i < times; i++) {
            ElementsCollection buttons = $$(".added-manually");
            if (!buttons.isEmpty()) {
                int randomIndex = random.nextInt(buttons.size());
                buttons.get(randomIndex).click();
                expectedCount--;
            } else {
                break;
            }
        }
        verifyVisibleElementsCount(expectedCount);
    }

    @Step("Проверяем, что видимо {expectedCount} элементов")
    public void verifyVisibleElementsCount(int expectedCount) {
        ElementsCollection visibleElements = $$(".added-manually");
        int actualCount = visibleElements.size();
        assertEquals(expectedCount, actualCount,
                String.format("Ожидалось: %d видимых элементов, но было: %d", expectedCount, actualCount));
    }
}




