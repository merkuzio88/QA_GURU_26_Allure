package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class Elements {

    public final String REPOSITORY = "eroshenkoam/allure-example";
    public final String ISSUE_TITLE = "Issue for HW qa.guru";
    public final SelenideElement searchInput = $(".search-input-container");
    public final SelenideElement activeSearchInput = $("#query-builder-test");
    public final SelenideElement linkRepository = $(linkText(REPOSITORY));
    public final SelenideElement issueTab = $("#issues-tab");
    public final SelenideElement controlIssue = $(withText(ISSUE_TITLE));
}
