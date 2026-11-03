package lssn12;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;



public class TestGoogleSearch extends BaseBrowserSetup {

    @BeforeAll
    static void SetupBrowser() {
        Configuration.baseUrl = "https://google.com";
    }

    //@DisplayName(value = "Параметризированный тест")
    @ParameterizedTest(name = "Поиск {0}")
    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    @CsvSource({
            "Selenide, https://selenide.org",
            "JUnit 5, https://junit.org"})

    void simpleTest(String productName, String productUrl) {
        open("/");
        $("[name='q']").setValue(productName).pressEnter();
        $("#search").shouldBe(visible);


      //  Assertions.assertTrue(10 > 2);

    }

    @Disabled //аннотация отключения теста
    @Test
    @DisplayName("Проверка суммы")
    void myTest() {
        int result = 5 + 20;
        Assertions.assertEquals(25, result);
    }


}
