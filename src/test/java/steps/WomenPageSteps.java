package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.TShirtsPage;
import pages.WomenPage;

public class WomenPageSteps {
    WebDriver webDriver = Setup.driver;
    WomenPage womenPage = new WomenPage(webDriver);

    @Then("I am redirected to the Women product page")
    public void iAmRedirectedToTheOngletProductPage() {
        Assert.assertTrue(womenPage.womenTitleIsDisplayed());

    }
}
