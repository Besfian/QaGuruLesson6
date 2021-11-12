package ru.mail.besfian;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTestStep {
    AllureLifecycle lifecycle = Allure.getLifecycle();

    @Step("Open the main page {url}")
    public void openPage(String url) {
        open(url);
    }

    @Step("Open the Lesson page {lesson}")
    public void openLesson(String lesson) {
        $(byText(lesson)).click();
    }

    @Step("Open the Issues page {issues}")
    public void openIssues(String issues) {
        $(partialLinkText(issues)).click();
    }

    @Step("We check that Issues Test visible {issuesTest}")
    public void checkVisibleissuesTest(String issuesTest) {
        $(byText(issuesTest)).shouldBe(Condition.visible);
    }

    @Step("created Screenshot")
    public void createdScreenshot() {
        lifecycle.addAttachment("Screenshot", "image/png", "png", getScreenshot());
    }

    private byte[] getScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
