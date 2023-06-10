// разметка, step что бы красиво в отчете было
// build - clean очистить старый алюр отчет
// запускаем тест
// other - allureServe - новый отчет получаем

//«лямбда степы»  step("   ", () -> {
//
//        });
//аттачмент в виде снапшота страницы.
package io.github.guru.allure;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AnnotatedAttachmentTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUESNUMBER = 68;

    @Test
    public void testGithub() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
            takeScreenshot();
            takePageSource();
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            // ищем в репозитории
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);//eroshenkoam/allure-example вместо         $(".header-search-input").sendKeys("eroshenkoam/allure-example");
            $(".header-search-input").submit();
            takeScreenshot();
            takePageSource();
        });
        // кликаем по тексту eroshenkoam/allure-example
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
            takeScreenshot();
            takePageSource();
        });
        step("Открываем раздел issues ", () -> {
            $("#issues-tab").click();
            takeScreenshot();
            takePageSource();
        });
        step("Проверяем  раздел issues с номером " + ISSUESNUMBER, () -> {
            $(byText("#" + ISSUESNUMBER)).should(Condition.visible); // упадет / вместо    $(byText("#68")).should(Condition.visible); // упадет
        });


    }

    @Attachment(value = "Страница", type = "text/html")
    public byte [] takePageSource() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8); // возвращает исходный код страницы
    }
    // для добавления скриншотов к step
     @Attachment(value = "Скриншот", type = "image/png")
    public byte [] takeScreenshot() {
  //  return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
return screenshot(OutputType.BYTES);
    }
}