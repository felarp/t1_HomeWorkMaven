package pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StatusCodesPage extends BasePage {

    @Step("Открываем раздел со статусом {code}")
    public void clickStatusCodeLink(String code) {
        $x("//a[contains (text(), '" + code + "')]").click();
    }

    @Step("Получаем значение статуса")
    public String getStatusText() {
        return $("div.example p").getText();
    }
    @Step("Возвращаемся к списку статусов")
    public void clickReturnLink() {
        $("a[href='/status_codes']").click();
    }
}