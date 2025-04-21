package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MyCreditSlipsPage;

/**
 * Cette classe contient les étapes de test pour la page {@link MyCreditSlipsPage}
 */
public class MyCreditSlipsPageSteps {
    WebDriver webDriver = Setup.driver;
    MyCreditSlipsPage myCreditSlipsPage = new MyCreditSlipsPage(webDriver);

    /**
     * Implémentation de l'étape "I see the list of my assets".
     * Vérifie que l'utilisateur voit la liste de ses avoirs
     * en contrôlant l'affichage du titre spécifique à cette page.
     *
     * @throws AssertionError si le titre de la page My Credit Slips n'est pas visible
     */
    @Then("I see the list of my assets")
    public void assertOnAssetsLists(){
               Assert.assertEquals("CREDIT SLIPS", myCreditSlipsPage.getPageTitle());
    }

}
