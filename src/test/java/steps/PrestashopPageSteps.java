package steps;

import hooks.Setup;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.PrestashopPage;

public class PrestashopPageSteps {

    WebDriver driver = Setup.driver;
    PrestashopPage prestashopPag = new PrestashopPage(driver);


    @Then("I am redirected to the PrestaShop partner site")
    public void iAmRedirectedToThePrestaShopPartnerSite() {

        Assert.assertTrue(prestashopPag.titrePrestashopIsDisplayed());

    }

}
