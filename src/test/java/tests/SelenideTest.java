package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import components.Elements;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest extends TestBase {

    Elements elements = new Elements();
    @Test
    @Feature("Issue in repository")
    @Story("Issue search")
    @Owner("merkuzio88")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Issue text search in repository")
    public void issueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        elements.searchInput.click();
        elements.activeSearchInput.sendKeys(elements.REPOSITORY);
        elements.activeSearchInput.submit();
        elements.linkRepository.click();
        elements.issueTab.click();
        elements.controlIssue.should(exist);
    }
}
