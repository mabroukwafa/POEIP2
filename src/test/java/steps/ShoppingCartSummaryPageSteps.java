package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ShoppingCartSummaryPage;
import pages.TShirtsPage;

public class ShoppingCartSummaryPageSteps {

    WebDriver driver = Setup.driver;
    ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);

    @Then("I am redirected to the <Shopping Cart Summary> page")
    public void iAmRedirectedToTheShoppingCartSummaryPage() {
        Assert.assertEquals("SHOPPING-CART SUMMARY", shoppingCartSummaryPage.getTitle());
    }
}

