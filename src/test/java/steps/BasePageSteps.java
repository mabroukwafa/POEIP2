package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.BlogPage;

public class BasePageSteps {

    private final WebDriver webDriver = Setup.driver;
    BasePage BasePage = new BasePage(webDriver);


    @When("I click on the \"BLOG\" tab")
    public void IClickOnTheBlogTab() {
        BasePage.clickOnBlogTab();

        //fetch handles of all windows, there will be two, [0]- default, [1] - new window
        Object[] windowHandles = webDriver.getWindowHandles().toArray();
        webDriver.switchTo().window((String) windowHandles[1]);

    }


    @When("I click on Sign in")
    public void iClickOnSignIn() {
        BasePage.clickOnSignIn();
    }


    @When("I click on Contact us")
    public void iClickOnContactUs() {
        BasePage.clickOnContactUs();
    }


}
