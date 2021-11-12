package ru.mail.besfian;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepAnnotatedSelenideTest {
    DataBase dataBase = new DataBase();
    SelenideTestStep step = new SelenideTestStep();

    @Owner("sergeev")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Github test with Allure labels, clean StepAnnotatedSelenideTest")
    @Test
    void stepAnnotatedSelenideTest() {
        step.openPage(dataBase.url);
        step.openLesson(dataBase.lesson);
        step.openIssues(dataBase.menuIssues);
        step.checkVisibleissuesTest(dataBase.issues);
        step.createdScreenshot();

    }
}
