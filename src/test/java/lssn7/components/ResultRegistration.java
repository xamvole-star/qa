package lssn7.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultRegistration {
    public ResultRegistration verifyTest(String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text(value));
        System.out.println("Форма загружена");
        return this;
    }

    public ResultRegistration verifyForm(String rowName, String expectedText) {
        $$(".table-responsive")
                .findBy(text(rowName)).parent()
                .$$("td").findBy(text(expectedText))
                .shouldHave(text(expectedText));
        return this;
    }


}


