package pages;

import assertions.CommonAssertion;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;


public class HoversPage extends BasePage {

    private final ElementsCollection images = $$(".figure img");
    private final ElementsCollection captions = $$(".figcaption h5");

    @Step("Проверяем количество изображений на странице")
    public void verifyImagesCount(int expectedCount) {
        int actualCount = images.size();
        CommonAssertion.assertEquals(actualCount, expectedCount,
                "Количество изображений на странице не соответствует ожидаемому");
    }
    @Step("Наводим курсор на изображение под индексом {index} и проверяем подпись")
    public void hoverAndCheckCaption(int index, String expectedCaption) {
        images.get(index).hover();
        String actualCaption = captions.get(index).getText();
        CommonAssertion.assertEquals("name: " + expectedCaption, actualCaption,
                "Подпись не совпадает для изображения с индексом: " + index);


    }
}

