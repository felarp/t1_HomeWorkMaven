package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.InfiniteScrollPage;
import pages.MainPage;

public class InfiniteScrollUiTest extends BaseTest {
    MainPage mainPage = new MainPage();
    InfiniteScrollPage infiniteScrollPage = new InfiniteScrollPage();

    @Test
    @Description("Тест проверяет, что текст 'Eius' становится видимым при прокрутке.")
    public void testScrollToEiusText() {

        mainPage.goToPage("infinite_scroll");

        infiniteScrollPage.scrollUntilTextIsVisible("Eius");

        infiniteScrollPage.verifyTextIsDisplayed("Eius");
    }
}

