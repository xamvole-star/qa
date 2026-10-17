package lssn7;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage_DemoQa {
    private SelenideElement lastUserNamber = $("#userNumber");


 public RegistrationPage_DemoQa openPage(){

     open("/automation-practice-form");
     return this;
    }

 public RegistrationPage_DemoQa setFirstName(String value){

     $("#firstName").setValue(value);
     return this;
 }

public RegistrationPage_DemoQa setLastName(){

     $("#lastName").setValue("Ivanov2");
     return this;
}

public RegistrationPage_DemoQa setUserEmail(String value){

     $("#userEmail").setValue(value);
     return this;
    }

public RegistrationPage_DemoQa setUserNumber(String value){

     lastUserNamber.setValue(value);
     return this;
    }



}
