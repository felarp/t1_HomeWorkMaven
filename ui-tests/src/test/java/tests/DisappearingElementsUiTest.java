package tests;

import io.qameta.allure.Description;
import pages.BasePage;
import pages.DisappearingElementsPage;
import pages.MainPage;
import org.junit.jupiter.api.RepeatedTest;


public class DisappearingElementsUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage();

    @RepeatedTest(10)
    @Description("Тест на проверку наличия пяти элементов на странице исчезающих элементов.")
    public void disappearingElementsTest() {
        mainPage.goToPage("disappearing_elements");

        disappearingElementsPage.verifyFiveElements();
        BasePage.refreshPage();
    }
}

