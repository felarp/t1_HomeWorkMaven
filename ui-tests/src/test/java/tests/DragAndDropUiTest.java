package tests;

import enums.Urls;
import org.junit.jupiter.api.Test;
import pages.DragAndDropPage;
import pages.MainPage;


public class DragAndDropUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Test
    public void testDragAndDrop() {
        openBrowser(Urls.MAINPAGE.getUrl());
        mainPage.goToPage("drag_and_drop");

        dragAndDropPage.performDragAndDrop();
        dragAndDropPage.verifyColumnsSwapped();
    }
}
