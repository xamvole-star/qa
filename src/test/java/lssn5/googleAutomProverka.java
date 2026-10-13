package lssn5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;


public class googleAutomProverka {

    @Test
    void InvisibleAutomatisation() {
        // Настройка браузера
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen =true; // чтобы бразуер не закрылся, для поиска Css селекторов итд
        Configuration.pageLoadStrategy = "eager"; //стратегия загрузки, не дожидаемся полной загрузки

//скрыть факт автоматизации //todo допилить, не работает обход
        ChromeOptions options = new ChromeOptions(); // создаем новый объект для обхода ботов
        options.addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browserCapabilities = options;

//Основной тест
        open("https://google.com");

        $("[aria-label='Найти']").setValue("It`s my life").pressEnter();
        System.out.println("This is the best test"); // suit
        int i = 42;
        Assertions.assertTrue(i>2);

    }
}