package tests;

import enums.Urls;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.KeyPressesPage;
import pages.MainPage;


public class KeyPressesUiTest extends BaseTest {
    MainPage mainPage = new MainPage();
    KeyPressesPage keyPressesPage = new KeyPressesPage();

    @Test
    @Description("Тест на нажатие клавиш на странице Key Presses и проверка всплывающего текста.")
    public void testKeyPresses() {
        openBrowser(Urls.MAINPAGE.getUrl());
        mainPage.goToPage("key_presses");


        String[] keys = {
                "A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J",
                "ENTER", "CONTROL", "ALT", "TAB"
        };

        String[] expectedResults = {
                "You entered: A", "You entered: B", "You entered: C",
                "You entered: D", "You entered: E", "You entered: F",
                "You entered: G", "You entered: H", "You entered: I",
                "You entered: J", "You entered: ENTER",
                "You entered: CONTROL", "You entered: ALT", "You entered: TAB"
        };

        for (int i = 0; i < keys.length; i++) {
            keyPressesPage.pressKeyAndCheck(keys[i], expectedResults[i]);
        }
    }
}





