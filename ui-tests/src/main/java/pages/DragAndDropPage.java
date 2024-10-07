package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;


public class DragAndDropPage {
    private SelenideElement columnA = $("#column-a");
    private SelenideElement columnB = $("#column-b");

    public void performDragAndDrop() {

        int xOffset = columnB.getLocation().getX() - columnA.getLocation().getX() + columnB.getSize().getWidth() / 2;
        int yOffset = columnB.getLocation().getY() - columnA.getLocation().getY() + columnB.getSize().getHeight() / 2;

        actions().clickAndHold(columnA)
                .moveByOffset(xOffset, yOffset)
                .release()
                .build()
                .perform();


        columnA.shouldHave(text("B"));
        columnB.shouldHave(text("A"));
    }

    public void verifyColumnsSwapped() {
        String textInColumnA = columnA.getText();
        String textInColumnB = columnB.getText();


        if (textInColumnA.equals("A") && textInColumnB.equals("B")) {
            System.out.println("Элементы поменялись местами: " + textInColumnA + " и " + textInColumnB);
        } else {
            throw new AssertionError("Элементы не поменялись местами. " +
                    "Ожидалось: Column A - B, Column B - A. " +
                    "Фактически: Column A - " + textInColumnA + ", Column B - " + textInColumnB);
        }
    }
}





