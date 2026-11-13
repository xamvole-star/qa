package lssn15;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import lssn12.BaseBrowserSetup;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest extends BaseBrowserSetup {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String REPO = "[aria-label ='Search GitHub']";
    private static final Integer ISSUE = 77;

    @Test // хорошая читаемость, плохая переиспользуемость
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/search");
        });
        step("Переходим в поиск на странице гитхаба", () -> {
            $(REPO).click();
        });

        step("Ищем репозиторий и жмем ентер", () -> {
            $(REPO).setValue(REPOSITORY).pressEnter();
        });
        step("Кликаем по ссылке ремозитория", () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Проверяем наличае Issue с номером" + ISSUE, () -> {

            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test // хорошая переиспользуемость, хуже читаемость, лучше использовать этот подход

    public void testAnnotatedStep() {
        WebSteps steps = new WebSteps();
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage(REPO);
        steps.searchForRepository(REPO, REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.shouldSeeIssueWithNumber(ISSUE);


    }


}