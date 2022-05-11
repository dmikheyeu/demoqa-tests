package guru.qa.docs;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpathExamples() {
        // <input type="email".class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email]").setValue("123");
        $(by("data-testid", "email")).setValue("123");

        // <input type="email".class="inputtext login_form_input_box" name="email" id="email">
        $("[id=email]").setValue("123");
        $("#email").setValue("123");
        $(byId("email")).setValue("123");
        $(By.id("email")).setValue("123");
        $x("//*[@id='email']").setValue("123");
        $(byXpath("//*[@id='email']")).setValue("123");

        // <input type="email".class="inputtext login_form_input_box" name="email">
        $("[name=email]").setValue("123");
        $(byName("email")).setValue("123");

        // <input type="email".class="inputtext login_form_input_box">
        $("[class=login_form_input_box]").setValue("123");
        $(".login_form_input_box").setValue("123");
        $(".input.inputtext.login_form_input_box").setValue("123");
        $x("//input[@class='login_form_input_box']").setValue("123");
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("123");
    }
}
