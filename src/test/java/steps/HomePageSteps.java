package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.ConfigReader;


public class HomePageSteps {

    private final WebDriver webDriver = Setup.driver;
    HomePage homePage = new HomePage(webDriver);


    @Given("I am on the Home page")
    public void iAmOnTheHomePage() {
        Assert.assertEquals(ConfigReader.getProperty("homePageUrl"), webDriver.getCurrentUrl());

    }


}
