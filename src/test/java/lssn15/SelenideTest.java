package lssn15;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lssn12.BaseBrowserSetup;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends BaseBrowserSetup {

    @Test
    public void testIssueSearch () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/search");

        $("[aria-label ='Search GitHub']").click();
        $("[aria-label ='Search GitHub']").setValue("eroshenkoam/allure-example").pressEnter();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#80")).should(Condition.exist);
    }

}