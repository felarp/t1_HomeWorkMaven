package pages;

import static com.codeborne.selenide.Selenide.$x;


public class MainPage extends BasePage {

    public void goToPage(String pageName) {
        $x("//a[@href='/" + pageName + "']").click();
    }
}
