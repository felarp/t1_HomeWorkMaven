package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import java.util.Random;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddRemoveElementsPage extends BasePage {
    Random random = new Random();


    @Step("Кликаем по кнопке 'Add Element', делая это {times} раз")
    public void clickAddElementButton(int times) {
        for (int i = 0; i < times; i++) {
            $("button[onclick='addElement()']").shouldBe(Condition.visible).click();
        }
        verifyVisibleElementsCount($$(".added-manually").size()); // Проверяем в конце добавления
    }

    @Step("Удаляем элементы, делая это {times} раз")
    public void deleteElements(int times) {
        for (int i = 0; i < times; i++) {
            ElementsCollection buttons = $$(".added-manually");
            if (!buttons.isEmpty() && !(buttons.size() < times)) {
                int randomIndex = random.nextInt(buttons.size());
                buttons.get(randomIndex).shouldBe(Condition.visible).click();
            } else {
                throw new AssertionError("Коллеция пуста или количество элементов меньше количества нажатий");
            }
        }
        verifyVisibleElementsCount($$(".added-manually").size());
    }

    @Step("Проверяем, что видимо {expectedCount} элементов")
    public void verifyVisibleElementsCount(int expectedCount) {
        ElementsCollection visibleElements = $$(".added-manually");
        assertEquals(expectedCount, visibleElements.size(),
                String.format("Ожидалось: %d видимых элементов, но было: %d", expectedCount, visibleElements.size()));
    }
}




