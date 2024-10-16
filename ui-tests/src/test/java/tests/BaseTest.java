package tests;

import configuration.WebDriverManager;
import enums.Urls;
import listeners.AllureListener;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(AllureListener.class)
public class BaseTest {
    static WebDriverManager driver = new WebDriverManager();
    public static ProjectConfig config;

    @BeforeEach
    public void setUp() {
        config = ConfigFactory.create(ProjectConfig.class);
        String baseUrl = config.baseUrl();
        openBrowser(baseUrl +Urls.MAINPAGE.getUrl());
    }



    public static void openBrowser(String url) {
        driver.browserUp(url);
    }

    @AfterEach
    public void close() {
        driver.browserTearDown();
    }
}

