package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    @BeforeAll
    static void setUpUrl() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void registrationForm() {
        String firstName = "Elisey";
        String lastName = "Kvasnikov";
        String email = "ekvasnikov@gmail.com";

        String phoneNumber = "375291234567";
        String currentAddress = "Belarus, Minsk";

        open("/automation-practice-form");
        sleep(50000);
        zoom(0.6);

        //Name
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);

        //Email
        $("[id=userEmail]").setValue(email);

        //Gender
        $("#genterWrapper").find(byText("Male")).click();

        //Phone
        $("[id=userNumber]").setValue(phoneNumber);

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("June")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1994")).click();
        $(".react-datepicker__month").find(byText("17")).click();

        //Subjects
        $("#subjectsInput").setValue("Mat");
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").setValue("Physics");
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").setValue("Computer Science");
        $("#subjectsInput").pressEnter();

        //Hobbies
        $("#hobbiesWrapper").find(byText("Reading")).click();

        //Picture
        $("#uploadPicture").setValue("/Users/dmiheev/Screenshots/Lacoste.png");

        //Navigation to click button
        $("#submit").hover();

        //Current Address
        $("#currentAddress").setValue(currentAddress);

        //State and City
        $("#state").click();
        $("#state").find(byText("Rajasthan")).click();
        $("#city").click();
        $("#city").find(byText("Jaipur")).click();

        //Press submit
        $("#submit").click();

        //Asserts
        $(".modal-content").shouldHave(Condition.text("Thanks for submitting the form"),
                Condition.text(firstName), Condition.text(lastName), Condition.text(email),
                Condition.text(phoneNumber), Condition.text(currentAddress));
    }
}
