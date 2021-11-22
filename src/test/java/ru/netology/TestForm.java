package ru.netology;

import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;


public class TestForm {

Date date = new Date();

    @Test
    public void formTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Москва");
        $("[data-test-id='date'] .input__control").setValue(Date.localDate());
        $("[data-test-id='name'] .input__control").setValue("Мария Иванова");
        $("[data-test-id='phone'] .input__control").setValue("+74954994444");
        $(withText("соглашаюсь")).click();
        $(byText("Забронировать")).click();
        $(".notification").shouldBe(appear, Duration.ofSeconds(15));
    }
}
