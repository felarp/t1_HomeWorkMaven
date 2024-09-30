package tests;

import enums.Urls;
import org.junit.jupiter.api.Test;
import pages.InputsPage;
import pages.MainPage;

import java.util.Random;

public class InputsUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    InputsPage inputsPage = new InputsPage();
    Random random = new Random();

    @Test

public void inputsTest() {
    openBrowser(Urls.MAINPAGE.getUrl());
    mainPage.goToInputsPage();

    int randomNumber = 1 + random.nextInt(10000);
    inputsPage.enterRandomNumber(randomNumber);
    String value = inputsPage.getInputValue();

        System.out.println("Значение введенного числа : " + value);
    }
}






