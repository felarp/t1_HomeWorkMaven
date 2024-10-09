package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

        public class DragAndDropPage {
            private SelenideElement columnA = $("#column-a");
            private SelenideElement columnB = $("#column-b");

            @Step("Перетаскивание элемента A на элемент B")
            public void performDragAndDrop() {

                actions().clickAndHold(columnA)
                        .moveToElement(columnB)
                        .release()
                        .build()
                        .perform();

                verifyColumnsSwapped();
            }
            @Step("Проверка, что элементы поменялись местами")
            public void verifyColumnsSwapped() {
                String textInColumnA = columnA.getText();
                String textInColumnB = columnB.getText();


                if (textInColumnA.equals("B") && textInColumnB.equals("A")) {
                    System.out.println("Элементы успешно поменялись местами: Column A = B, Column B = A");
                } else {
                    throw new AssertionError("Элементы не поменялись местами. " +
                            "Ожидалось: Column A - B, Column B - A. " +
                            "Фактически: Column A - " + textInColumnA + ", Column B - " + textInColumnB);
                }
            }
        }





