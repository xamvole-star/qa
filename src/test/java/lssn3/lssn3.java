package lssn3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class lssn3 {
    @Test
    void Test() {
        // open("https://github.com/selenide/selenide"); // можно было не заморачиваться а так сделать сразу
        Configuration.holdBrowserOpen =true;

        open("https://github.com/search");
        $("[aria-label='Search GitHub']").setValue("selenide").pressEnter();
        $$("[data-testid=results-list]").first().$("a").click(); // открывается первая ссылка get(2) - третья ссылка

// Перейти в раздел Wiki
        $("[href='/selenide/selenide/wiki']").click();

// Убедиться, что в списке страниц есть SoftAssertions
        $(".js-wiki-more-pages-link").click();

        // Открыть страницу SoftAssertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();

// Проверить, что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("JUnit5"));
        //sleep(6000);
    }
}