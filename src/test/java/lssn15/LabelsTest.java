package lssn15;

import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test //статические аннтотации
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("xamvole-star")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void testStaticLabels() {
    }

    @Disabled
    @Test //альтернатива того, что сверху, динамические аннотации, для проверок условий итд
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTest(
                t -> t.setName("Создание Issue для авторизованного пользователя")
        );
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "xamvole-star");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }

}