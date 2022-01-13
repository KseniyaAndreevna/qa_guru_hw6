package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.IssueTestsConstants.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class IssueLambdaStepsTest {

    @Test
    public void testIssueSearchLambdaSteps() {

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Находим репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим в репозиторий", () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем, название Issue в репозитории с номером " + NUMBER, () -> {
            $("#issue_" + NUMBER + "_link").shouldHave(text(ISSUE_NAME));
        });
    }
}
