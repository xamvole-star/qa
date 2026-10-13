package lssn4;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class lssn4 {

    @Test
    void Lesson4() {

// Запрещаем Selenide закрывать браузер после теста
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1028";

//На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
        open("https://github.com");
        // element("div[class*='NavDropdown-module__button']");
        $(byText("Solutions")).hover();
        $("a[href*='/enterprise']").hover().click();

//Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
        $("h1").shouldHave(text("GitHub Enterprise"));


    }
}