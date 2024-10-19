package configuration;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class WebDriverManager {


    static {
        Configuration.browser = "chrome";
        Configuration.browserPosition = "0x0";
        Configuration.browserVersion = "129.0";
        Configuration.timeout = 20*1000;
        Configuration.pageLoadTimeout = 30*1000;
        Configuration.browserSize = "1900x1080";

    }

    public  void browserUp(String url) {
        open(url);
    }

    public void browserTearDown() {
        closeWebDriver();
    }
}