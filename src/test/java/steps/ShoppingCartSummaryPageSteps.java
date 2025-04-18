package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ShoppingCartSummaryPage;
import pages.TShirtsPage;

public class ShoppingCartSummaryPageSteps {
    /*
        * Classe implémentant les étapes Cucumber relatives à la page ShoppingCartSummary.
     */
    WebDriver driver = Setup.driver;
    ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);

    /*
        * Implémentation de l'étape "I am redirected to the Shopping Cart Summary page".
        * Vérifie que l'utilisateur est bien redirigé vers la page Shopping Cart Summary
        * en confirmant l'affichage du titre spécifique à cette page.
        *
        * @throws AssertionError si le titre de la page Shopping Cart Summary n'est pas visible

     */
    @Then("I am redirected to the <Shopping Cart Summary> page")
    public void iAmRedirectedToTheShoppingCartSummaryPage() {
        Assert.assertEquals("SHOPPING-CART SUMMARY", shoppingCartSummaryPage.getTitle());
    }
}

