package pages;
import static com.codeborne.selenide.Selenide.$x;


public class MainPage extends BasePage{


    public void goToCheckboxesPage() {
        $x("//a[@href='/checkboxes']").click();
    }

    public void goToDropdownPage() {
        $x("//a[@href='/dropdown']").click();
    }

    public void goToDisappearingElementsPage() {
        $x("//a[@href='/disappearing_elements']").click();
    }
    public  void goToInputsPage() {
        $x("//a[@href ='/inputs']").click();
    }
    public void goToHoversPage() {
        $x("//a[@href ='/hovers']").click();
    }
}
