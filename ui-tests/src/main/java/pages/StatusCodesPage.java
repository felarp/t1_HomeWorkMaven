package pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatusCodesPage extends BasePage {

    @Step("Открываем раздел со статусом {code}")
    public void clickStatusCodeLink(String code) {
        $x("//a[contains(text(), '" + code + "')]").click();
        verifyStatusCode(code);
    }

    @Step("Получаем значение статуса")
    public String getStatusText() {
        return $("div.example p").getText();
    }

    @Step("Возвращаемся к списку статусов")
    public void clickReturnLink() {
        $("a[href='/status_codes']").click();
    }

    @Step("Проверка, что текущий статус соответствует ожидаемому коду {expectedCode}")
    public void verifyStatusCode(String expectedCode) {
        String actualStatusText = getStatusText();
        assertTrue(actualStatusText.contains(expectedCode), "Ожидалось, что текст будет содержать статус: " + expectedCode + ", но получено: " + actualStatusText);
    }
}
