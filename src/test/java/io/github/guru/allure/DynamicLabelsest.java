// разметка, step что бы красиво в отчете было
// build - clean очистить старый алюр отчет
// запускаем тест
// other - allureServe - новый отчет получаем

//«лямбда степы»  step("   ", () -> {
//
//        });
//аттачмент в виде снапшота страницы.
package io.github.guru.allure;

// разметку текста перенесли в код (динамический код), ПЕРЕИСПОЛЬЗОВАНИЕ,  в отличии от разметки(аннотаций)
// когда большой проект

//listner (слушатель)  - что бы слушать последовательность действий

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.*;


/* Через аннотации (разметку) - СТАТИЧЕСКИЙ
*   @Feature("Issue")
    @Owner("osetrova") // кто тест писал в отчтете
    @Test
    @Story("Поиск по Issue") // название в алюре
    @Link(name = "Главная страница", url="https://github.com") // сслыка в отчете на страницу
    @DisplayName("Проверка того, что мы можем поискать конкретную Issue") // название теста
    @Severity(SeverityLevel.BLOCKER) // Критичность теста
    *
    *
    *
    С аннотациями нельзя применять код if и тд, с ДИНАМИЧЕСКИМИ можно
*/

public class DynamicLabelsest {


    @Test
    @DisplayName("Проверка того, что мы можем поискать конкретную Issue") // название теста
    public void testGithub() {
        label("owner","osetrova");
        feature("Issue");
        story("Поиск по Issue");
        label("severity","SeverityLevel.BLOCKER");
        link("Главная страница", "https://github.com");
        step("Открываем главную страницу", () -> {
            open("https://github.com");
            addAttachment("Hello", "World");

        });

    }
}