package lssn7;

import lssn7.components.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectJavaTest extends TestBase {

    @Test
    void testers() {
        String userName = "Ivan";
        String userEmail = "IvanovIvanIvanovich@mail.ru";
        String userNumber = "1234567890";
        String userLastName = "Ivanov";
        String day = "17";
        String month = "May";
        String year = "1958";

        registrationPageDemoQa
                .openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setUserEmail(userEmail)
                .setUserNumber(userNumber)
                .setDate(day, month, year)
                .subjectsInput("Computer Science")
                .subjectsInput("English")
                .subjectsInput("Math");

        $("#gender-radio-1").click();

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
//
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        registrationPageDemoQa.verifyTest();

        $(".table-responsive").$(byText)

        //  $("#root").hover().click(); // todo разобраться как закрыть это окно
    }
}



