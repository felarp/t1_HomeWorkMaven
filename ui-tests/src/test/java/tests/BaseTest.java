package tests;

import configuration.WebDriverManager;
import listeners.AllureListener;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;


@ExtendWith(AllureListener.class)
public class BaseTest {
    static WebDriverManager driver = new WebDriverManager();

     ProjectConfig projectConfig = ConfigFactory.create((ProjectConfig.class));

    @BeforeEach
    public void setUp() {

       open(projectConfig.baseUrl());
    }


    @AfterEach
    public void close() {
        driver.browserTearDown();
    }
}

