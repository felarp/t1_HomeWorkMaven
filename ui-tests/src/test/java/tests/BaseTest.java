package tests;

import configuration.WebDriverManager;
import org.junit.jupiter.api.AfterEach;


public class BaseTest {

    WebDriverManager driver = new WebDriverManager();

    public void openBrowser(String url) {
        driver.browserUp(url);
    }

    @AfterEach
    public void closeBrowser() {
        driver.browserTearDown();
    }
}
