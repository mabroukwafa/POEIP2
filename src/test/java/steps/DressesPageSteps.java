package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BlogPage;
import pages.DressesPage;

public class DressesPageSteps {

    WebDriver webDriver = Setup.driver;
    DressesPage dressesPage = new DressesPage(webDriver);

    @Then("I am redirected to the Dresses product page")
    public void iAmRedirectedToTheOngletProductPage() {
        Assert.assertTrue(dressesPage.dressesTitleIsDisplayed());
    }



}
