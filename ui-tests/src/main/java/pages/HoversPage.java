package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class HoversPage extends BasePage {

    private final ElementsCollection images =  $$(".figure img");
    private final ElementsCollection captions = $$(".figcaption h5");

    @Step("Наводим курсор на изображения и выводим подписи")
    public void hoverOverImagesAndPrintCaptions() {
        for (int i = 0; i < images.size(); i++) {
            images.get(i).hover();
            System.out.println("Caption: " + captions.get(i).getText());

        }
    }

}
