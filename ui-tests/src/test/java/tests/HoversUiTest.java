package tests;

import enums.Urls;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.HoversPage;
import pages.MainPage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoversUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    HoversPage hoversPage = new HoversPage();

    @ParameterizedTest
    @CsvSource({
            "0, user1",
            "1, user2",
            "2, user3"
    })
    @Description("Параметризованный тест для проверки подписей при наведении на изображения")
    public void hoverOverImagesTest(int index, String expectedCaption) {
        mainPage.goToPage("hovers");

        hoversPage.hoverAndCheckCaption(index, expectedCaption);
    }
    @Test
    @Description("Тест для проверки количества изображений на странице")
    public void verifyImagesCount() {
        openBrowser(Urls.MAINPAGE.getUrl());
        mainPage.goToPage("hovers");

        assertEquals(3, hoversPage.getImagesCount());
    }
}

