// разметка, step что бы красиво в отчете было
// build - clean очистить старый алюр отчет
// запускаем тест
// other - allureServe - новый отчет получаем

//«лямбда степы»  step("   ", () -> {
//
//        });
//аттачмент в виде снапшота страницы.
package io.github.guru.allure;

// парамметрезированные тесты


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.*;

@Feature("Issue")
@Owner("osetrova") // кто тест писал в отчтете

public class RegionsTest {
    @ParameterizedTest // парамметрезированные тесты
    @ValueSource(strings = {"Москва", "Санкт-Петербург"})
    public void testGithub(String region) {
        parameter("Регион", region);

        step("Открываем главную страницу в регионе " + region, () -> {
            open("https://github.com");
            addAttachment("Hello", "World!");

        });

    }
}