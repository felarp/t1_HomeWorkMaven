package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.HoversPage;
import pages.MainPage;

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
        hoversPage.verifyImagesCount(3);
    }
}

