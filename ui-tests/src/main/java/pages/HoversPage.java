package pages;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HoversPage extends BasePage {

    private final ElementsCollection images =  $$(".figure img");
    private final ElementsCollection captions = $$(".figcaption h5");

    public void hoverOverImagesAndPrintCaptions() {
        for (int i = 0; i < images.size(); i++) {
            actions().moveToElement(images.get(i)).perform();
            captions.get(i).shouldBe(visible);
            System.out.println("Caption: " + captions.get(i).getText());

        }
    }

}
