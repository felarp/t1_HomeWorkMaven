package tests;

import configuration.WebDriverManager;
import enums.Urls;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {

    @BeforeEach
    public void setUp() {
        openBrowser(Urls.MAINPAGE.getUrl());
    }

    static WebDriverManager driver = new WebDriverManager();


    public  static void openBrowser(String url) {
        driver.browserUp(url);
    }

    @AfterEach
    public void close() {
        driver.browserTearDown();
    }
}
