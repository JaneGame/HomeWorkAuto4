package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestElementsForm {



    @Test
    public void elementsTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Мо");
        $(byText("Москва")).click();
        $("[data-test-id='date']").click();
        $("[data-test-id='date'] .input__control").setValue("30.11.2022");
        $("[data-test-id='name'] .input__control").setValue("Мария Иванова");
        $("[data-test-id='phone'] .input__control").setValue("+74954994444");
        $(withText("соглашаюсь")).click();
        $(byText("Забронировать")).click();
        $(".notification").shouldBe(appear, Duration.ofSeconds(15));
    }
}
