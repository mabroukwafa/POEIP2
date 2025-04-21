package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;

/***
 * Cette classe contient les étapes de définition de {@link PasswordResetPage}.
 */
public class PasswordResetPageSteps {
    WebDriver webDriver = Setup.driver;
    HomePage homePage = new HomePage(webDriver);
    LoginPage loginPage = new LoginPage(webDriver);
    CreateAccountPage createAccountPage = new CreateAccountPage(webDriver);
    PasswordResetPage passwordResetPage = new PasswordResetPage(webDriver);

    /**
     * Implémentation de l'étape "I am redirected on the Password reset page".
     * Vérifie que l'utilisateur est bien redirigé vers la page de réinitialisation du mot de passe
     * en confirmant l'affichage du titre spécifique à cette page.
     *
     * @throws AssertionError si le titre de la page de réinitialisation du mot de passe n'est pas visible
     */
    @Then("I am redirected on the <Password reset> page")
    public void iRedirectedOnThePasswordResetPage() {
        Assert.assertEquals("FORGOT YOUR PASSWORD?", passwordResetPage.getTitle());
    }

    /**
     * Implémentation de l'étape "I am on the Password reset page".
     * Implémente la logique pour naviguer vers la page de réinitialisation du mot de passe
     * puis en confirmant l'affichage du titre spécifique à cette page.
     *
     * @throws AssertionError si le titre de la page de réinitialisation du mot de passe n'est pas visible
     */
    @Given("I am on the <Password reset> page")
    public void iAmOnThePasswordResetPage() {
        homePage.clickOnSignIn();
        loginPage.sendEmailCreate(YopMailPageSteps.resetPasswordMail);
        loginPage.clickCreateAccountButton();
        createAccountPage.fillrequired("Reset","Password","password");
        createAccountPage.clickRegister();
        createAccountPage.clickOnSignOut();
        loginPage.clickForgotPassword();
        Assert.assertEquals("FORGOT YOUR PASSWORD?", passwordResetPage.getTitle());
    }


    /**
     * Implémentation de l'étape "I enter my registered email".
     * Envoie l'email enregistré pour la réinitialisation du mot de passe.
     */
    @When("I enter my registered email")
    public void iEnterMyRegisteredEmail() {
        passwordResetPage.sendEmail(YopMailPageSteps.resetPasswordMail);
    }

    /**
     * Implémentation de l'étape "I click the <Retrieve Password> button".
     * Clique sur le bouton de réinitialisation du mot de passe.
     * @throws AssertionError si le message de confirmation avant la réinitialisation n'est pas visible
     */
    @And("I click the <Retrieve Password> button")
    public void iClickTheRetrievePasswordButton() {
        passwordResetPage.clickButton();
        Assert.assertTrue(passwordResetPage.isConfirmationMessageBeforeResetVisible());
    }

    /**
     * Implémentation de l'étape "I should see a message that confirms the password change".
     * Vérifie que l'utilisateur voit un message de confirmation après la réinitialisation du mot de passe.
     * @throws AssertionError si le message de confirmation après la réinitialisation n'est pas visible
     */
    @Then("I should see a message that confirms the password change")
    public void iShouldSeeAMessageThatConfirmsThePasswordChange() {
        Assert.assertTrue(passwordResetPage.isConfirmationMessageAfterResetVisible());
    }
}
