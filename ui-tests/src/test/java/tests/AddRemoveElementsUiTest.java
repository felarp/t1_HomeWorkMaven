package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Description;
import listeners.AllureListener;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import pages.AddRemoveElementsPage;
import pages.MainPage;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;


public class AddRemoveElementsUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage();

    @TestFactory
    @Description("Динамический тест на добавление и удаление элементов на странице добавления/удаления элементов.")
    public Stream<DynamicTest> testAddAndRemoveElements() {
        int[][] params = {
                {2,1},
                {5,2},
                {1,3}
        };
        return Arrays.stream(params).map(param-> {
            int add = param[0];
            int remove = param[1];
            String displayName = "Adding: " + add + " times and remove: " + remove + " times";
            return  DynamicTest.dynamicTest(displayName, () -> {
                addRemoveElements(add,remove);
            });
        });
    }

    public void addRemoveElements(int addClickTimes, int removeClickTimes) {
        setUp();
        mainPage.goToPage("add_remove_elements/");
        addRemoveElementsPage.clickAddElementButton(addClickTimes);
        addRemoveElementsPage.deleteElements(removeClickTimes);
        close();
    }

}




