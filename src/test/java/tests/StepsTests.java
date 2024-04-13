package tests;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTests extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_TITLE = "Issue for HW qa.guru";
    private static final SelenideElement searchInput = $(".search-input-container");
    private static final SelenideElement activeSearchInput = $("#query-builder-test");
    private static final SelenideElement linkRepository = $(linkText(REPOSITORY));
    private static final SelenideElement issueTab = $("#issues-tab");
    private static final SelenideElement controlIssue = $(withText(ISSUE_TITLE));

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

        step("Looking for a repository " + REPOSITORY, () -> {
            searchInput.click();
            activeSearchInput.sendKeys(REPOSITORY);
            activeSearchInput.submit();
        });

        step("Click on the repository link " + REPOSITORY, () -> {
            linkRepository.click();
        });

        step("Opening the Issues tab", () -> {
            issueTab.click();
        });

        step("Checking for an Issue with a title " + ISSUE_TITLE, () -> {
            controlIssue.should(exist);
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
        steps.searchForRepository(searchInput, activeSearchInput, REPOSITORY);
        steps.clickOnRepositoryLink(linkRepository);
        steps.openIssuesTab(issueTab);
        steps.shouldSeeIssueWithTitle(controlIssue);

    }
}
