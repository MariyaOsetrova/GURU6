package io.github.guru.allure;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.util.EventListener;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

// что бы понимать на приметивном уровне
// будут выводиться прям шаги с селекторами в отчете
//.as("Поисковая строка") что бы выводилось не селектор а то название которое укажем
public class SelenideListenerTest {

    @Test
    public void testGithub() {
        SelenideLogger.addListener("allure", new AllureSelenide()); // подключили 1 addListener + в гредле добавили зависимость
        open("https://github.com");
        // ищем в репозитории
        $(".header-search-input").as("Поисковая строка").click();
        $(".header-search-input").as("Поисковая строка").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").as("Поисковая строка").submit();
        // кликаем по тексту eroshenkoam/allure-example
        $(linkText("eroshenkoam/allure-example")).as("Ссылка репозитория").click();
        $("#issues-tab").as("Таб Issue").click();
        $(byText("#68")).as("Issue с номером").should(Condition.visible); // упадет


    }

}