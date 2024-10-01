package tests;

import configuration.WebDriverManager;
import org.junit.jupiter.api.AfterAll;


public class BaseTest {

    static WebDriverManager driver = new WebDriverManager();

    public  static void openBrowser(String url) {
        driver.browserUp(url);
    }

    @AfterAll
    public static void closeBrowser() {
        driver.browserTearDown();
    }
}
