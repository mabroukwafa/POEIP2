package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;
import utils.ConfigReader;


public class HomePageSteps {

    WebDriver webDriver = Setup.driver;
    HomePage homePage = new HomePage(webDriver);
    BasePage basePage = new BasePage(webDriver);


    @Given("I am on the Home page")
    public void iAmOnTheHomePage() {
        Assert.assertEquals(ConfigReader.getProperty("homePageUrl"), webDriver.getCurrentUrl());

    }

    @And("the menu bar should show {string}")
    public void theMenuBarShouldShow(String signIn) {
        Assert.assertEquals(basePage.getSignInText(), signIn);

    }


}
