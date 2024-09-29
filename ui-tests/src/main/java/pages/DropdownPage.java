package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DropdownPage extends BasePage{

private final SelenideElement optionField = $x("//select[@id = 'dropdown']");
}
