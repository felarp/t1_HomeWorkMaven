package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoversPage extends BasePage {

    private final ElementsCollection images = $$(".figure img");
    private final ElementsCollection captions = $$(".figcaption h5");

    @Step("Наводим курсор на изображение под индексом {index} и проверяем подпись")

    public void hoverAndCheckCaption(int index, String expectedCaption) {
        images.get(index).hover();
        String actualCaption = captions.get(index).getText();
        assertEquals("name: " + expectedCaption, actualCaption,
                "Подпись не совпадает для изображения с индексом: " + index);
    }

    public int getImagesCount() {
        return images.size();
    }
}

