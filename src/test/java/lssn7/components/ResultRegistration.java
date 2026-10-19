package lssn7.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultRegistration {
    public void verifyTest(String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text(value));
    }


}


