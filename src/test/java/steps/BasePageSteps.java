package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.BlogPage;

public class BasePageSteps {

    WebDriver webDriver = Setup.driver;
    BasePage basePage = new BasePage(webDriver);


    @When("I click on the \"BLOG\" tab")
    public void IClickOnTheBlogTab() {
        basePage.clickOnBlogTab();

        //fetch handles of all windows, there will be two, [0]- default, [1] - new window
        Object[] windowHandles = webDriver.getWindowHandles().toArray();
        webDriver.switchTo().window((String) windowHandles[1]);

    }


    @When("I click on Sign in")
    public void iClickOnSignIn() {
        basePage.clickOnSignIn();
    }


    @When("I click on Contact us")
    public void iClickOnContactUs() {
        basePage.clickOnContactUs();
    }


    @When("I click on the logo")
    public void iClickOnTheLogo() {
        basePage.clickOnLogo();
    }

    @And("the search bar is visible")
    public void theSearchBarIsVisible() {
        Assert.assertTrue(basePage.isFieldSearchVisible());
    }

    @When("I type {string} in the search bar")
    public void iTypeInTheSearchBar(String item) {
        basePage.insertInFieldSearch(item);
    }

    @And("I select the suggestion {string}")
    public void iSelectTheSuggestion(String suggestion) {
        basePage.chooseSuggestion(suggestion);
    }

    @And("I click on the search icon")
    public void iClickOnTheSearchIcon() {
        basePage.clickOnLoupeSearch();
    }
}
