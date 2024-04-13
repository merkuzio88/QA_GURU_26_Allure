package tests;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final SelenideElement searchInput = $(".search-input-container");
    private static final SelenideElement activeSearchInput = $("#query-builder-test");
    private static final SelenideElement linkRepository = $(linkText(REPOSITORY));
    private static final SelenideElement issueTab = $("#issues-tab");
    private static final SelenideElement controlIssue = $(withText("Issue for HW qa.guru"));

    @Test
    @Feature("Issue in repository")
    @Story("Issue search")
    @Owner("merkuzio88")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Issue text search in repository")
    public void issueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        searchInput.click();
        activeSearchInput.sendKeys(REPOSITORY);
        activeSearchInput.submit();
        linkRepository.click();
        issueTab.click();
        controlIssue.should(exist);
    }
}
