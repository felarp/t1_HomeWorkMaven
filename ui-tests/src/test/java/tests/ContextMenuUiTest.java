package tests;

import org.junit.jupiter.api.Test;
import pages.ContextMenuPage;
import pages.MainPage;
import io.qameta.allure.Description;


public class ContextMenuUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    ContextMenuPage contextMenuPage = new ContextMenuPage();

    @Test
    @Description("Тест проверяет, что при правом клике на области контекстного меню появляется JS Alert с ожидаемым текстом")
    public void testContextMenuAlert() {
        mainPage.goToPage("context_menu");

        contextMenuPage
                .rightClickContextMenu()
                .acceptAndVerifyAlert("You selected a context menu");
    }
}

