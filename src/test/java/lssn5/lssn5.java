package lssn5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class lssn5 {
/* будем повторять 3 урок и делать ключи ssh для гита
просто взял и сюда добавил на гитхабе изменения
*/


    @Test
    void GithubProverkaLesson3() {
// Настройка браузера
        Configuration.browser = "chrome";
        //  Configuration.timeout = 60000;
        //   Configuration.browserSize = "1900x1200"; // установка разрешения браузера
        Configuration.holdBrowserOpen =true; // чтобы бразуер не закрылся, для поиска Css селекторов итд
        Configuration.pageLoadStrategy = "eager"; //стратегия загрузки, не дожидаемся полной загрузки


//скрыть факт автоматизации
        ChromeOptions options = new ChromeOptions(); // создаем новый объект для обхода ботов
        options.addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browserCapabilities = options;




//Основной тест
        open("https://github.com");

// Разворачиваем окно на весь экран и получаем размер в виде сообщения, нужно ставить после запуска, открытия бразуера иначе будет ошибка
        getWebDriver().manage().window().maximize();
        System.out.println("Real size: " + getWebDriver().manage().window().getSize());

        $("[class*='HeaderSearch-module__searchSlot']").shouldHave(text("Search")).click();
        $("[aria-label*='Search or jump to']").setValue("selenide").pressEnter();
        $("[data-testid='results-list']").$("a[href*='/selenide/selenide']").hover().click();
        $("[alt*='@vinogradoff']").hover().shouldBe(Condition.visible);
    }
}