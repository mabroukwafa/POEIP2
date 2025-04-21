package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;

/**
 * Cette classe contient les étapes de test pour la page {@link PersonalInformationPage}
 */
public class PersonalInformationPageSteps {
    WebDriver webDriver = Setup.driver;
    PersonalInformationPage personalInformationPage= new PersonalInformationPage(webDriver);

    /**
     * Implémentation de l'étape "I can view my personal information on the Personal information page".
     * Vérifie que l'utilisateur peut voir ses informations personnelles sur la page
     * en confirmant l'affichage du titre spécifique à cette page.
     * @throws AssertionError si le titre de la page Personal Information n'est pas visible
     */
    @Then("I can view my personal information on the Personal information page")
    public void assertOnPersonalInformationPage() {
        Assert.assertEquals("YOUR PERSONAL INFORMATION", personalInformationPage.getTitle());
    }


}
