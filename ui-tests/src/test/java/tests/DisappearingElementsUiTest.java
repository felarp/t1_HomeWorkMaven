package tests;

import enums.Urls;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.DisappearingElementsPage;
import pages.MainPage;

public class DisappearingElementsUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage();

    @Test
    @Description("Тест на поиск пяти элементов с попытками на странице исчезающих элементов.")
    public void disappearingElementsTest() {

        mainPage.goToPage("disappearing_elements");
        disappearingElementsPage.findFiveElementsWithAttempts(10);

    }
}