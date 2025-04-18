package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DressesPage;
import pages.TShirtsPage;

public class TShirtsPageSteps {

    WebDriver webDriver = Setup.driver;
    TShirtsPage tShirtsPage = new TShirtsPage(webDriver);

    @Then("I am redirected to the T-Shirts product page")
    public void iAmRedirectedToTheOngletProductPage() {
        Assert.assertTrue(tShirtsPage.tShirtTitleIsDisplayed());

    }
}
