package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import components.Elements;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTests extends TestBase {

    Elements elements = new Elements();

    @Test
    @Feature("Issue in repository")
    @Story("Issue search")
    @Owner("merkuzio88")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Issue text search in repository with lambda steps")
    public void issueSearchWithSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Opening the main page", () -> {
            open("https://github.com");
        });

        step("Looking for a repository " + elements.REPOSITORY, () -> {
            elements.searchInput.click();
            elements.activeSearchInput.sendKeys(elements.REPOSITORY);
            elements.activeSearchInput.submit();
        });

        step("Click on the repository link " + elements.REPOSITORY, () -> {
            elements.linkRepository.click();
        });

        step("Opening the Issues tab", () -> {
            elements.issueTab.click();
        });

        step("Checking for an Issue with a title " + elements.ISSUE_TITLE, () -> {
            elements.controlIssue.should(exist);
        });
    }

    @Test
    @Feature("Issue in repository")
    @Story("Issue search")
    @Owner("merkuzio88")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Issue text search in repository with annotated steps")
    public void issueSearchAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(elements.searchInput, elements.activeSearchInput, elements.REPOSITORY);
        steps.clickOnRepositoryLink(elements.linkRepository);
        steps.openIssuesTab(elements.issueTab);
        steps.shouldSeeIssueWithTitle(elements.controlIssue);

    }
}
