package steps;

import hooks.Setup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.util.List;
import java.util.Map;

/**
 * Cette classe contient les étapes de test pour la page {@link YourAddressesPage}.
 */
public class YourAddressesPageSteps {
    WebDriver driver = Setup.driver;
    YourAddressesPage addressesPage = new YourAddressesPage(driver);

    /**
     * Implémentation de l'étape "I fill in the following fields:".
     * Cette méthode remplit les différents champs du formulaire via l'objet dataTable.
     * @param dataTable Tableau de données contenant les informations à remplir.
     */
    @And("I fill in the following fields:")
    public void IFillInTheFollowingFields(DataTable dataTable){
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        addressesPage.sendFirstname(rows.get(0).get("firstname"));
        addressesPage.sendLastname(rows.get(0).get("lastname"));
        addressesPage.sendCompany(rows.get(0).get("company"));
        addressesPage.sendAddress1(rows.get(0).get("address1"));
        addressesPage.sendAddress2(rows.get(0).get("address2"));
        addressesPage.sendCity(rows.get(0).get("city"));
        addressesPage.sendState(rows.get(0).get("state"));
        addressesPage.sendPostcode(rows.get(0).get("postalCode"));
        addressesPage.sendCountry(rows.get(0).get("country"));
        addressesPage.sendHomePhone(rows.get(0).get("homePhone"));
        addressesPage.sendMobilephone(rows.get(0).get("mobilePhone"));
        addressesPage.sendInformation(rows.get(0).get("additionalInformation"));
        addressesPage.sendAddressTitle(rows.get(0).get("addressTitle"));
    }

    /**
     * Implémentation de l'étape "I save the changes".
     * Cette méthode clique sur le bouton de sauvegarde.
     */
    @And("I save the changes")
    public void iSaveTheChanges() {
        addressesPage.clickButton();
    }


    /**
     * Implémentation de l'étape "I fill in the new following fields:".
     * @param dataTable Tableau de données contenant les informations à remplir.
     */
    @And("I fill in the new following fields:")
    public void iFillInTheNewFollowingFields(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        addressesPage.sendMobilephone(rows.get(0).get("phone"));
        addressesPage.sendAddress1(rows.get(0).get("address"));
    }

    /**
     * Implémentation de l'étape "I am redirected to the address entry page".
     * Vérifie que l'utilisateur est bien redirigé vers la page d'entrée d'adresse
     * en confirmant l'affichage du titre spécifique à cette page.
     * @throws AssertionError si le titre de la page d'entrée d'adresse n'est pas visible
     */
    @Then("I am redirected to the address entry page")
    public void iAmRedirectedToTheAddressEntryPage() {
        Assert.assertEquals("YOUR ADDRESSES", addressesPage.getPageTitle());
    }
}
