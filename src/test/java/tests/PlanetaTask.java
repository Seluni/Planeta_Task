package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class PlanetaTask extends BaseTest{



    @Description("Задание по Баранцеву")
    @Feature("Barancev Task")
    @Test
    public void SimpleTest(){
        open("http://localhost/litecart/admin/login.php");

//        $("#lst-ib").setValue("Webdriver").submit();
        $(".form-control[name=\"username\"]").setValue("admin");
        $(".form-control[name=\"password\"]").setValue("admin");
        $(".btn.btn-default").click();

        $("#notices > .alert.alert-success").shouldHave(text(" You are now logged in as admin"));

        ElementsCollection sideurls = $$("#app-");


        for (SelenideElement sideurl :sideurls){
            sideurl.click();
            $("#main > h1").shouldBe(visible);
            ElementsCollection innerurls = $$("#app- > ul > li");
            if (innerurls.size() != 0) {
                for (SelenideElement innerurl : innerurls) {
                    innerurl.click();
                    $("#main > h1").shouldBe(visible);
                }
            }
        }
    }
}
