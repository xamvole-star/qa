package lssn7.tests;

import lssn7.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistrationWithPageObjectJavaTest extends TestBase {
    @Test
    void testers() {
        //variables for filling out the form
        String userName = "Ivan";
        String userEmail = "IvanovIvanIvanovich@mail.ru";
        String userNumber = "1234567890";
        String userLastName = "Ivanov";
        String day = "17";
        String month = "May";
        String year = "1958";
        String address = "Moscow city, Lenina 244 /45";
        String state = "Haryana";
        String city = "Karnal";
        String path = "pic/photo_202623.jpg";
        String gender = "1";
        String hobbySports = "1";
        String hobbyReading = "2";
        String hobbyMusic = "3";

        //variables for checks todo сделать потом списком или массивом для красоты
        String studentName = "Student Name";
        String studentEmail = "Student Email";
        String studentGender = "Gender";
        String studentCityAndState = "State and City";
        String studentAddress = "Address";
        String formName = "Thanks for submitting the form";
        String fullName = userName + userLastName;

        registrationPageDemoQa
                .openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setUserEmail(userEmail)
                .setUserNumber(userNumber)
                .setDate(day, month, year)
                .subjectsInput("Computer Science")
                .subjectsInput("English")
                .subjectsInput("Math")
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .uploadPicture(path)
                .setGender(gender)
                .setHobby(hobbySports)
                .setHobby(hobbyReading)
                .setHobby(hobbyMusic)
                .submit();

        resultRegistration
                .verifyTest(formName)
                .verifyForm(studentName, fullName)
                .verifyForm(studentEmail, userEmail)
                .verifyForm(studentCityAndState, state + " " + city)
                .verifyForm(studentAddress, address);

        //  System.out.println("Real size: " + getWebDriver().manage().window().getSize());
        //  $("#root").hover().click(); // todo разобраться как закрыть это окно
    }
}



