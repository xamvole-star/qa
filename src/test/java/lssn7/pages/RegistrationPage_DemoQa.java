package lssn7.pages;

import com.codeborne.selenide.SelenideElement;
import lssn7.components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage_DemoQa {
    private SelenideElement
            lastUserNumber = $("#userNumber"),
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            currentAddress = $("#currentAddress"),
            uploadPicture = $("#uploadPicture"),
            submitInput = $("#submit"),
            setState = $("#state"),
            setcity = $("#city");



    Calendar calendar = new Calendar();

    private static  String
            GENDER_RADIO = "#gender-radio-",
            HOBBIE = "#hobbies-checkbox-";


    public RegistrationPage_DemoQa openPage() {
        open("/automation-practice-form");
        // Удаляем рекламные баннеры
//      executeJavaScript("$('#fixedban').remove(); $('footer').remove();");
        return this;
    }

    public RegistrationPage_DemoQa setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationPage_DemoQa setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage_DemoQa setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage_DemoQa setUserNumber(String value) {
        lastUserNumber.setValue(value);
        return this;
    }

    public RegistrationPage_DemoQa setDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage_DemoQa subjectsInput(String value) {
        subjectsInput.click();
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage_DemoQa setAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage_DemoQa setState(String value) {
        setState.click();
        setState.$(byText(value)).click();
        return this;
    }

    public RegistrationPage_DemoQa setCity(String value) {
        setcity.click();
        setcity.$(byText(value)).click();
        return this;
    }

    public RegistrationPage_DemoQa uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage_DemoQa setGender(String value) {
        $(GENDER_RADIO + value).click();
        return this;
    }

    public RegistrationPage_DemoQa setHobby(String value) {
        $(HOBBIE + value).click();
        return this;
    }

    public RegistrationPage_DemoQa submit() {
        submitInput.click();
        return this;
    }

}
