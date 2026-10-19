package lssn7;

import lssn7.components.TestBase;
import org.junit.jupiter.api.Test;

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
        String address = "Moscow city, Lenina 244 /45";
        String state = "Haryana";
        String city = "Karnal";
        String path = "pic/photo_202623.jpg";
        String gender = "1";
        String hobbySports = "1";
        String hobbyReading = "2";
        String hobbyMusic = "3";

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
                .setAdress(address)
                .setState(state)
                .setCity(city)
                .uploadPicture(path)
                .setGender(gender)
                .setHobby(hobbySports)
                .setHobby(hobbyReading)
                .setHobby(hobbyMusic)
                .submit()
                .verifyTest("Thanks for submitting the form");


        //  $("#root").hover().click(); // todo разобраться как закрыть это окно
    }
}



