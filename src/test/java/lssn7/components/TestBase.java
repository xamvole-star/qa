package lssn7.components;

import com.codeborne.selenide.Configuration;
import lssn7.RegistrationPage_DemoQa;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

   protected RegistrationPage_DemoQa registrationPageDemoQa = new RegistrationPage_DemoQa();

    @BeforeAll
    static  void SetupBrowser(){
        Configuration.browserSize = "1920x1200";
        Configuration.holdBrowserOpen = true; // для отладки
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

//todo разобраться с обходом автоматизации гугла, не достаточно blink, похоже надо задавать браузер итд
        ChromeOptions options = new ChromeOptions(); // создаем новый объект для обхода ботов
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setCapability("webSocketUrl", false);
        Configuration.browserCapabilities = options;
    }




}
