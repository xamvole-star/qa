package lssn7;

import com.codeborne.selenide.SelenideElement;
import lssn7.components.Calendar;
import lssn7.components.ResultRegistration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage_DemoQa {
    private SelenideElement lastUserNumber = $("#userNumber");
    Calendar calendar = new Calendar();
    ResultRegistration resultRegistration = new ResultRegistration();

    public RegistrationPage_DemoQa openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage_DemoQa setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrationPage_DemoQa setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrationPage_DemoQa setUserEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationPage_DemoQa setUserNumber(String value) {
        lastUserNumber.setValue(value);
        return this;
    }

    public RegistrationPage_DemoQa setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage_DemoQa subjectsInput(String value) {
        $("#subjectsInput").click();
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage_DemoQa setAdress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationPage_DemoQa setState(String value) {
        $("#react-select-3-input").click();
        $$("div[id^='react-select-3-option']").findBy(text(value)).click();
        return this;
    }

    public RegistrationPage_DemoQa setCity(String value) {
        $("#react-select-4-input").click();
        $$("div[id^='react-select-4-option']").findBy(text(value)).click();        return this;
    }

    public RegistrationPage_DemoQa uploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage_DemoQa setGender(String value) {
        $("#gender-radio-" + value).click();
        return this;
    }

    public RegistrationPage_DemoQa setHobby(String value) {
        $("#hobbies-checkbox-" + value).click();
        return this;
    }
    public ResultRegistration submit() {
        $("#submit").click();
        return resultRegistration;
    }

}
