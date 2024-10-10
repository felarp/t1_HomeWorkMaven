package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import pages.AddRemoveElementsPage;
import pages.MainPage;
import java.util.List;
import java.util.stream.Stream;


public class AddRemoveElementsUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage();

    @TestFactory
    @Description("Динамический тест на добавление и удаление элементов на странице добавления/удаления элементов.")
    public Stream<DynamicTest> testAddAndRemoveElements() {
        mainPage.goToPage("add_remove_elements/");

        List<TestParams> testParams = List.of(
                new TestParams(2, 1),
                new TestParams(5, 2),
                new TestParams(1, 3)
        );

        return testParams.stream()
                .map(params -> DynamicTest.dynamicTest(
                        "Добавить " + params.added + " элементов и удалить " + params.removed + " элементов",
                        () -> {
                            addRemoveElementsPage.clickAddElementButton(params.added);
                            addRemoveElementsPage.deleteElements(params.removed);
                        }
                ));
    }

    private static class TestParams {
        int added;
        int removed;

        TestParams(int added, int removed) {
            this.added = added;
            this.removed = removed;
        }
    }
}




