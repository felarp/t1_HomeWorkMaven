package tests;

import enums.Urls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import pages.AddRemoveElementsPage;
import pages.MainPage;
import java.util.Map;
import java.util.stream.Stream;

public class AddRemoveElementsUiTest extends BaseTest {

    MainPage mainPage = new MainPage();
    AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage();

    @TestFactory
    @DisplayName("Параметризованные тесты на добавление и удаление элементов")
    Stream<DynamicTest> testAddAndRemoveElements() {
        openBrowser(Urls.MAINPAGE.getUrl());
        mainPage.goToPage("add_remove_elements/");

        Map<Integer, Integer> testData = Map.of(
                2, 1,
                5, 2,
                1, 3
        );

        return testData.entrySet().stream().map(entry -> {
            int additions = entry.getKey();
            int deletions = entry.getValue();

            return DynamicTest.dynamicTest("Добавляем: " + additions + ", Удаляем: " + deletions, () -> {
                addRemoveElementsPage.clickAddElementButtonAndVerify(additions);
                addRemoveElementsPage.deleteElementsAndVerify(deletions);
            });
        });
    }
}

