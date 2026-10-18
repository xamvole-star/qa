package lssn7;

import com.codeborne.selenide.SelenideElement;
import lssn7.components.Calendar;
import lssn7.components.ResultRegistration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage_DemoQa {
    private SelenideElement lastUserNamber = $("#userNumber");
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
        lastUserNamber.setValue(value);
        return this;
    }

    public RegistrationPage_DemoQa setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.SetDate(day, month, year);
        return this;
    }

    public RegistrationPage_DemoQa subjectsInput(String value) {
        $("#subjectsInput").click();
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

//    public RegistrationPage_DemoQa verifyTest(){
////        resultRegistration.verifyModalApperance();
//
//        return this;
//    }

}
