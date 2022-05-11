package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        String name = "Elisey Kvasnikov";
        String email = "ekvasnikof@gmail.com";
        String currentAddress = "Some street 1";
        String permanentAddress = "Another street 2";

        open("/text-box");
        zoom(0.6);

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue(email);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=permanentAddress]").setValue(permanentAddress);
        $("[id=submit]").click();

        // Asserts
        $("[id=output]").shouldHave(Condition.text(name), Condition.text(email),
                Condition.text(currentAddress), Condition.text(permanentAddress));

        $("[id=output] [id=name]").shouldHave(Condition.text(name));
        $("[id=output]").$("[id=email]").shouldHave(Condition.text(email));

        $("p[id=permanentAddress]", 1).shouldHave(Condition.text("Permananet Address :Another street 2"));
        $("[id=permanentAddress]", 1).shouldHave(Condition.text("Permananet Address :Another street 2"));

        String expectedPermanentAddress = "Another street 2";
        String actualPermanentAddress = $("p[id=permanentAddress]").text();
        Assertions.assertEquals(expectedPermanentAddress, actualPermanentAddress);
    }
}