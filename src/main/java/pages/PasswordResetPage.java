package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object Model (POM) pour la page de réinitialisation de mot de passe.
 * Cette classe hérite de la classe {@link BasePage}.
 */
public class PasswordResetPage extends BasePage{

    /**
     * Constructeur de la classe {@link BasePage} que la classe PasswordResetPage hérite.
     * @param webDriver Instance WebDriver pour interagir avec le navigateur
     */
    public PasswordResetPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(xpath = "//h1[@class='page-subheading' and text()='Forgot your password?']")
    WebElement title;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//button[@type='submit']//span[contains(text(), 'Retrieve Password')]")
    WebElement retrievePasswordButton;

    @FindBy(xpath = "//p[contains(@class, 'alert-success') and contains(text(), 'confirmation email has been sent')]")
    WebElement confirmationMessageBeforeReset;

    @FindBy(xpath = "//p[contains(@class, 'alert-success') and contains(text(), 'Your password has been successfully reset')]")
    WebElement confirmationMessageAfterReset;

    /**
     * Méthode pour récupérer le titre de la page de réinitialisation de mot de passe.
     * @return Le texte du titre de la page
     */
    public String getTitle(){
        return title.getText();
    }


    /**
    * Méthode qui insère l'email dans le champ de saisie associé.
     */
    public void sendEmail(String email){
        emailField.sendKeys(email);
    }

    /**
    * Méthode pour cliquer sur le bouton de réinitialisation du mot de passe.²
     */
    public void clickRetrievePasswordButton(){
            retrievePasswordButton.click();
    }

    /**
     * Méthode pour vérifier si le message de confirmation avant la réinitialisation est visible.
     * @return true si le message est visible, sinon false
     */
    public Boolean isConfirmationMessageBeforeResetVisible(){
        return confirmationMessageBeforeReset.isDisplayed();
    }

    /**
     * Méthode pour vérifier si le message de confirmation après la réinitialisation est visible.
     * @return true si le message est visible, sinon false
     */
    public Boolean isConfirmationMessageAfterResetVisible(){
        return confirmationMessageAfterReset.isDisplayed();
    }



}
