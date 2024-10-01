package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StatusCodesPage extends BasePage {


    public void clickStatusCodeLink(String code) {
        $x("//a[contains (text(), '" + code + "')]").click();
    }

    public String getStatusText() {
        return $("div.example p").getText();
    }
    public void clickReturnLink() {
        $("a[href='/status_codes']").click();
    }
}