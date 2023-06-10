// разметка, step что бы красиво в отчете было
// build - clean очистить старый алюр отчет
// запускаем тест
// other - allureServe - новый отчет получаем

//«лямбда степы»  step("   ", () -> {
//
//        });
package io.github.guru.allure;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class lambdaStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUESNUMBER = 68;

    @Test
    public void testGithub() {
        step ("Открываем главную страницу",() ->{
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () ->{
            // ищем в репозитории
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);//eroshenkoam/allure-example вместо         $(".header-search-input").sendKeys("eroshenkoam/allure-example");
            $(".header-search-input").submit();
                });
        // кликаем по тексту eroshenkoam/allure-example
        step("Переходим в репозиторий " + REPOSITORY, () ->{
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем раздел issues ", () ->{
            $("#issues-tab").click();
        });
        step("Проверяем  раздел issues с номером " + ISSUESNUMBER, () ->{
            $(byText("#" + ISSUESNUMBER)).should(Condition.visible); // упадет / вместо    $(byText("#68")).should(Condition.visible); // упадет
        });



    }

}