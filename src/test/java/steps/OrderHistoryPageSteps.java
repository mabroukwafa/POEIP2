package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.OrderHistoryPage;

/**
 * Cette classe contient les étapes de test pour la page {@link OrderHistoryPage}
 */
public class OrderHistoryPageSteps {

    WebDriver webDriver = Setup.driver;
    OrderHistoryPage orderHistoryPage = new OrderHistoryPage(webDriver);

    /**
     * Implémentation de l'étape "I see the list of my orders on the Order History page".
     * Vérifie que l'utilisateur voit la liste de ses commandes sur la page d'historique des commandes
     * en contrôlant l'affichage du titre spécifique à cette page.
     *
     * @throws AssertionError si le titre de la page d'historique des commandes n'est pas visible
     */
    @Then("I see the list of my orders on the Order History page")
    public void assertOnOrderHistoryPage(){
        Assert.assertEquals("ORDER HISTORY", orderHistoryPage.getPageTitle());
    }


}
