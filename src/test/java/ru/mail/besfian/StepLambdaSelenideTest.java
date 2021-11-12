package ru.mail.besfian;

import com.codeborne.selenide.Condition;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaSelenideTest {
    DataBase dataBase = new DataBase();

    @Owner("sergeev")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Github test with Allure labels, clean StepLambdaSelenideTest")
    @Test
    void selenideTest() {
        step("Opening the repository Besfian", () -> {
            open(dataBase.url);
        });
        step("Opening the  QaGuruLesson6", () -> {
            $(byText(dataBase.lesson)).click();
        });
        step("Opening the Issues", () -> {
            $(partialLinkText(dataBase.menuIssues)).click();
        });
        step("We check that Issues Test visible", () -> {
            $(byText(dataBase.issues)).shouldBe(Condition.visible);
        });
    }
}
