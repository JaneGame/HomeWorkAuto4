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

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class TestForm {
    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver(2).exe");
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }


    @Test
    public void formTest() {
        open("http://localhost:9999");
        $$("[type='text']").exclude(hidden).first().setValue("Москва");
        $$("[type='tel']").exclude(hidden).first().setValue("30.11.2022");
        $$("[type='text']").exclude(hidden).last().setValue("Мария Иванова");
        $$("[type='tel']").exclude(hidden).last().setValue("+74954994444");
        $(withText("соглашаюсь")).click();
        $(byText("Забронировать")).click();
        $(".notification").shouldBe(appear, Duration.ofSeconds(15));
    }
}
