package lssn7.tests;

import lssn7.TestBase;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class JavaFaker extends TestBase {
    @Test
    void testers() {
        //variables for filling out the form
        Faker fakerRu = new Faker(new Locale("ru"));
        Faker fakerEn = new Faker(new Locale("en"));

        String userName = fakerRu.name().firstName();
        String userEmail = fakerEn.internet().emailAddress();
        String userNumber = fakerRu.phoneNumber().phoneNumber().replaceAll("\\D", "");
        String userLastName = fakerRu.name().lastName();
        String address = fakerEn.address().fullAddress();

        String day = "15";
        String month = "May";
        String year = "1958";
        String state = "Haryana";
        String city = "Karnal";
        String path = "pic/ptica_24921.jpg";
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
        String fullName = userName + " " + userLastName;

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
    }


}
