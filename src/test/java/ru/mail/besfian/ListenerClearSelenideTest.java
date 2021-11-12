package ru.mail.besfian;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.partialLinkText;

public class ListenerClearSelenideTest {
    DataBase dataBase = new DataBase();
    @Owner("sergeev")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Github test with Allure labels, clean ListenerClearSelenideTest")
    @Test
    void selenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(dataBase.url);
        $(byText(dataBase.lesson)).click();
        $(partialLinkText(dataBase.menuIssues)).click();
        $(byText(dataBase.issues)).shouldBe(Condition.visible);

    }


}
