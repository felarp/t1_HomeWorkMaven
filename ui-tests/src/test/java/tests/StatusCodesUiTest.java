package tests;

import enums.Urls;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.StatusCodesPage;

public class StatusCodesUiTest extends BaseTest {

    static MainPage mainPage = new MainPage();
    static StatusCodesPage statusCodePage = new StatusCodesPage();

    @BeforeAll
    public static void setUp() {

        openBrowser(Urls.MAINPAGE.getUrl());
        mainPage.goToPage("status_codes");
    }

    @Test
    @Description("Проверка статуса кода 200")
    public void testStatusCode200() {
        statusCodePage.clickStatusCodeLink("200");
        System.out.println(statusCodePage.getStatusText());
    }

    @Test
    @Description("Проверка статуса кода 301")
    public void testStatusCode301() {
        statusCodePage.clickStatusCodeLink("301");
        System.out.println(statusCodePage.getStatusText());
    }

    @Test
    @Description("Проверка статуса кода 404")
    public void testStatusCode404() {
        statusCodePage.clickStatusCodeLink("404");
        System.out.println(statusCodePage.getStatusText());
    }

    @Test
    @Description("Проверка статуса кода 500")
    public void testStatusCode500() {
        statusCodePage.clickStatusCodeLink("500");
        System.out.println(statusCodePage.getStatusText());
    }

    @AfterEach
    public void returnToStatusCodesPage() {
        statusCodePage.clickReturnLink();
    }
}
