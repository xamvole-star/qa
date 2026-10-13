package lssn7;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

    public class RegistrationWithPageObjectJavaTest {
        RegistrationPage_DemoQa registrationPageDemoQa = new RegistrationPage_DemoQa();

        @BeforeAll
        static  void SetupBrowser(){
            Configuration.browserSize = "1920x1200";
            Configuration.holdBrowserOpen = true;
            Configuration.timeout = 10000;
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.pageLoadStrategy = "eager";

//todo разобраться с обходом автоматизации гугла, не работает blink
            ChromeOptions options = new ChromeOptions(); // создаем новый объект для обхода ботов
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setCapability("webSocketUrl", false);
            Configuration.browserCapabilities = options;
        }

        @Test
        void testers() {
            String userName = "Egor";
            String userEmail = "IvanovIvanIvanovich@mail.ru";
            String userNumber = "1234567890";

            registrationPageDemoQa.openPage();
            registrationPageDemoQa.setFirstName(userName);
            registrationPageDemoQa.setLastName();
            registrationPageDemoQa.setUserEmail(userEmail);
            registrationPageDemoQa.setUserNumber(userNumber);



            $("#gender-radio-1").click();
            $("#dateOfBirthInput").click();
            $("[class='react-datepicker__year-select']").click();
            $(".react-datepicker__year-select").selectOption("1986");
            $(".react-datepicker__month-select").selectOption("May");
            $$(".react-datepicker__day").findBy(text("5")).click();

            $("#subjectsInput").click();
            $("#subjectsInput").setValue("Maths").pressEnter();
            $("#subjectsInput").setValue("English").pressEnter();
            $("#subjectsInput").setValue("Computer Science").pressEnter();

            $("#hobbies-checkbox-1").click();
            $("#hobbies-checkbox-2").click();
            $("#hobbies-checkbox-3").click();

            $("#uploadPicture").uploadFromClasspath("pic/photo_202623.jpg");

            $("#currentAddress").setValue("Moscow sity, Lenina 244 /45");

            $("[class='css-19bb58m']").click();
            $("#react-select-3-option-2").shouldHave(text("Haryana")).click();

            $("#react-select-4-input").click();
            $("#react-select-4-option-0").shouldHave(text("Karnal")).click();

            $("#submit").click();

            //  $("#root").hover().click(); // todo разобраться как закрыть это окно
        }
    }



