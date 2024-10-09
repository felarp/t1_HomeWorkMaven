package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.WebDriverManager;
import enums.Urls;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true));
        openBrowser(Urls.MAINPAGE.getUrl());
    }

    static WebDriverManager driver = new WebDriverManager();


    public  static void openBrowser(String url) {
        driver.browserUp(url);
    }

    @AfterAll
    public static void closeBrowser() {
        driver.browserTearDown();
    }
}
