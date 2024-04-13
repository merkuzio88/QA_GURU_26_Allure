package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Opening the main page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Looking for a repository {repo}")
    public void searchForRepository(SelenideElement searchInput, SelenideElement activeSearchInput, String repo) {
        searchInput.click();
        activeSearchInput.sendKeys(repo);
        activeSearchInput.submit();
    }

    @Step("Click on the repository link")
    public void clickOnRepositoryLink(SelenideElement repoLink) {
        repoLink.click();
    }

    @Step("Opening the Issues tab")
    public void openIssuesTab(SelenideElement tab) {
        tab.click();
    }

    @Step("Checking for an Issue with a title")
    public void shouldSeeIssueWithTitle(SelenideElement issue) {
        issue.should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
