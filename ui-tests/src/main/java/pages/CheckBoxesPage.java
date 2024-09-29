package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckBoxesPage extends BasePage {

    private final SelenideElement checkbox1 = $x("//form[@id='checkboxes']/input[1]");
    private final SelenideElement checkbox2 = $x("//form[@id='checkboxes']/input[2]");

    public void chooseCheckboxesAndPrintStates() {

        checkbox1.click();

       assertCheckboxState(checkbox1,true, "Checkbox 1");

       checkbox2.click();

        assertCheckboxState(checkbox2, false, "Checkbox 2");
    }

//    public void printFirstCheckboxState(){
//        boolean isChecked = checkbox1.isSelected();
//        System.out.println("Checkbox 1 is checked: " + isChecked);
//    }
//    public void printSecondCheckboxState(){
//        boolean isChecked = checkbox1.isSelected();
//        System.out.println("Checkbox 2 is checked: " + isChecked);
//    }
//
//   public boolean isFirstCheckboxChecked() {
//        return checkbox1.isSelected();
//    }
//
//    public boolean isSecondCheckboxChecked() {
//        return checkbox2.isSelected();
//    }
}