package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.DragAndDropPage;
import pages.MainPage;

public class DragAndDropUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    DragAndDropPage dragAndDropPage = new DragAndDropPage();


    @Test
    @Description("Тест проверяет функциональность перетаскивания элемента A на элемент B на странице Drag and Drop. " +
            "После перетаскивания проверяется, что элементы поменялись местами.")
    public void DragAndDropTest() {
        mainPage.goToPage("drag_and_drop");
        dragAndDropPage.performDragAndDrop();

    }
}
