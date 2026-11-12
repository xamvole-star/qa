package lssn12;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

public class BaseBrowserSetup {
    @DisplayName("Настройка браузера Chrome для тестов, обход обнаружения google автоматизации")
    @BeforeAll
    static void SetupBrowser() {
        Configuration.browserSize = "1920x1200";
//        Configuration.holdBrowserOpen = true; // Только для отладки
        Configuration.pageLoadStrategy = "eager";

        // Создаем объект опций для Chrome
        ChromeOptions options = new ChromeOptions();

        // Добавляем аргументы
        options.addArguments(List.of(
                "--disable-blink-features=AutomationControlled",
                "--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/156.0.0.0 Safari/537.36"
        ));

        // Отключаем сообщение "Chrome is being controlled by automated test software"
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        // Применяем настройки к Selenide
        Configuration.browserCapabilities = options;

    }
}

