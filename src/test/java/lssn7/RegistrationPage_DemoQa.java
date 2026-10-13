package lssn7;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage_DemoQa {
    private SelenideElement lastUserNamber = $("#userNumber");


 public void openPage(){
     open("/automation-practice-form");
    }

 public void setFirstName(String value){
     $("#firstName").setValue(value);
 }

public void setLastName(){
    $("#lastName").setValue("Ivanov2");
}

public void setUserEmail(String value){
    $("#userEmail").setValue(value);
    }

public void setUserNumber(String value){
     lastUserNamber.setValue(value);
    }



}
