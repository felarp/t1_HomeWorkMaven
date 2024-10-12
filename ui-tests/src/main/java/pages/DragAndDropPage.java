package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

        public class DragAndDropPage {
            private final SelenideElement columnA = $("#column-a");
            private final SelenideElement columnB = $("#column-b");

            @Step("Перетаскивание элемента A на элемент B")
            public void performDragAndDrop() {
                columnA.shouldBe(visible);
                actions().clickAndHold(columnA)
                        .moveToElement(columnB)
                        .release()
                        .build()
                        .perform();

                verifyColumnsSwapped();
            }
            @Step("Проверка, что элементы поменялись местами")
            public void verifyColumnsSwapped() {
                Assertions.assertEquals(columnB.getText(),"A","Элементы не поменялись местами");
                Assertions.assertEquals(columnA.getText(),"B","Элементы не поменялись местами");

            }
        }





