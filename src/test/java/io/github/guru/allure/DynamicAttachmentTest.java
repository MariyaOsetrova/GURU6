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

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class DynamicAttachmentTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUESNUMBER = 68;

    @Test
    public void testGithub() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
            addAttachment("Hello", "World");

        });

    }
}