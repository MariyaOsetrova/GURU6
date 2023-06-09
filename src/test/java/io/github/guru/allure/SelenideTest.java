package io.github.guru.allure;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void testGithub() {
        open("https://github.com");
        // ищем в репозитории
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();
        // кликаем по тексту eroshenkoam/allure-example
        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(byText("#68")).should(Condition.visible); // упадет


    }

}