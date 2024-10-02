package tests;

import enums.Urls;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.InputsPage;
import pages.MainPage;

import java.util.Random;

public class InputsUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    InputsPage inputsPage = new InputsPage();
    Random random = new Random();

    @Test
    @Description("Тест для ввода случайного числа на странице ввода и проверки отображения значения.")

    public void inputsTest() {
    openBrowser(Urls.MAINPAGE.getUrl());
    mainPage.goToPage("inputs");

    int randomNumber = 1 + random.nextInt(10000);
    inputsPage.enterRandomNumber(randomNumber);
    String value = inputsPage.getInputValue();

        System.out.println("Значение введенного числа : " + value);
    }
}






