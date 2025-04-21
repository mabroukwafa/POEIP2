package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.YopMailPage;
import utils.ConfigReader;

/**
 * Cette classe contient les étapes de test pour la page {@link YopMailPage}.
 */
public class YopMailPageSteps {

    WebDriver webDriver = Setup.driver;
    public static String resetPasswordMail;

    YopMailPage yopMailPage = new YopMailPage(webDriver);

    /**
     * Implémentation de l'étape "I created an email".
     * Cette méthode génère une adresse e-mail temporaire pour les tests.
     */
    @Given("I created an email")
    public void createYopMail(){
        yopMailPage.goToYopMailGenerator();
        yopMailPage.clickAuthorizeButton();
        yopMailPage.clickNewGenButton();
        resetPasswordMail = yopMailPage.getTextBeforeAt() + "@yopmail.com";
        yopMailPage.closeTab();
        yopMailPage.goToTab(0);

    }

    /**
     * Implémentation de l'étape "I check my emails".
     * Cette méthode permet de vérifier les e-mails reçus dans la boîte de réception.
     * @throws InterruptedException si le thread est interrompu pendant le sleep
     */
    @And("I check my emails")
    public void iCheckMyEmails() throws InterruptedException {
        Thread.sleep(1000L *  Integer.parseInt(ConfigReader.getProperty("yopmailTimeout")));
        yopMailPage.goToYopMailHomePage();
        yopMailPage.enterLogin(resetPasswordMail);
        yopMailPage.goToMail();
    }

    /**
     * Implémentation de l'étape "I click on the reset password link".
     * Cette méthode simule le clic sur le lien de réinitialisation du mot de passe dans l'e-mail.
     * @throws InterruptedException si le thread est interrompu pendant le sleep
     */
    @And("I click on the reset password link")
    public void iClickOnTheResetPasswordLink() throws InterruptedException {
        yopMailPage.clickRefreshButton();
        yopMailPage.clickPasswordResetLink();
        yopMailPage.goToTab(2);
    }
}
