package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.KeyPressesPage;
import pages.MainPage;


public class KeyPressesUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    KeyPressesPage keyPressesPage = new KeyPressesPage();

    @Test
    @Description("Тест на нажатие клавиш на странице Key Presses и проверка отображаемого текста.")
    public void testKeyPresses() {
        String[] keys = {
                "A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J",
                "ENTER", "CONTROL", "ALT", "TAB"
        };
        mainPage.goToPage("key_presses");
        keyPressesPage.checkListKeys(keys);
    }
}






