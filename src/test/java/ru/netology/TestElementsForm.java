package ru.netology;

import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.files.DownloadActions.click;

public class TestElementsForm {

    private Data dayPlus = new Data();
    private int plusDaysVidget = 10;

    String generateDate(int plusDaysVidget) {
        return LocalDate.now().plusDays(plusDaysVidget).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    public void elementsTest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Мо");
        $(byText("Москва")).click();
        $("[data-test-id='date']").click();
        $(".input__icon").click();
        if (dayPlus.monthCheck(plusDaysVidget)) {
            $("[data-step='1']").click();
        }
        $(byText(Data.day(plusDaysVidget))).click();
        $("[data-test-id='name'] .input__control").setValue("Мария Иванова");
        $("[data-test-id='phone'] .input__control").setValue("+74954994444");
        $(withText("соглашаюсь")).click();
        $(byText("Забронировать")).click();
        $(".notification__content").shouldBe(appear, Duration.ofSeconds(15))
        .shouldHave(exactText("Встреча успешно забронирована на " + generateDate(plusDaysVidget)));
    }
}
