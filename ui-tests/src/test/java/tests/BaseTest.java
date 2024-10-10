package tests;

import configuration.WebDriverManager;
import enums.Urls;
import listeners.AllureListener;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(AllureListener.class)
public class BaseTest {

    @BeforeEach
    public void setUp() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//                .screenshots(true));
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

//    @AfterAll
//    public static void closeBrowser() {
//        driver.browserTearDown();
//    }
}
