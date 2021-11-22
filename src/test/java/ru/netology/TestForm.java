package ru.netology;

import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;


public class TestForm {

    String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    public void formTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Москва");
        String planningDate = generateDate(4);
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(planningDate);
        $("[data-test-id='name'] .input__control").setValue("Мария Иванова");
        $("[data-test-id='phone'] .input__control").setValue("+74954994444");
        $(withText("соглашаюсь")).click();
        $(byText("Забронировать")).click();
        $(".notification__content").shouldBe(appear, Duration.ofSeconds(15))
        .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));
    }


}
