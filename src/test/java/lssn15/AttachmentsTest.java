package lssn15;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lssn12.BaseBrowserSetup;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest extends BaseBrowserSetup {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String REPO = "[aria-label ='Search GitHub']";
    private static final Integer ISSUE = 77;

    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу 1", () -> {
            open("https://github.com/search");
            attachment("Source", webdriver().driver().source());

        });

    }

    @Test

    public void testAnnotatedAttachments() {
        WebSteps steps = new WebSteps();
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage(REPO);
        steps.takeScreenshot();



    }

}
