package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

/**
 * Page Object Model (POM) pour la page YopMail.
 * Elle hérite de la classe {@link BasePage}.
 */
public class YopMailPage extends BasePage {

    //Xpath
    @FindBy(xpath = "//button[@aria-label='Autoriser']")
    WebElement authorizeButton;

    @FindBy(xpath = "//button[@onclick='newgen();']")
    WebElement newGenButton;

    @FindBy(xpath = "//button[@onclick='egengo();']")
    WebElement goToMailButton;

    @FindBy(xpath = "(//span[@class='genytxt'])[1]")
    WebElement beforeAt;

    @FindBy(xpath = "//a[contains(@href,'passw')]")
    WebElement passwordResetLink;

    @FindBy(id = "aswift_3")
    WebElement iframePopup;

    @FindBy(id = "dismiss-button")
    WebElement dismissButton;

    @FindBy(id = "refresh")
    WebElement refreshButton;

    @FindBy(id = "ifmail")
    WebElement iframeMail;

    /**
     * Constructeur de la classe {@link BasePage} que la classe YopMailPage hérite.
     * @param driver le WebDriver utilisé pour interagir avec le navigateur
     */
    public YopMailPage(WebDriver driver){
        super(driver);
    }

    /**
     * Méthode pour ouvrir un nouvel onglet et accéder à la page YopMail.
     */
    public void goToYopMailGenerator(){
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get("https://yopmail.com/fr/email-generator");
    }

    /**
     * Méthode pour cliquer sur le bouton "Autoriser" sur la page YopMail.
     */
    public void clickAuthorizeButton(){
        authorizeButton.click();
    }

    /**
     * Méthode pour cliquer sur le bouton "Nouveau Générateur" sur la page YopMail.
     */
    public void clickNewGenButton(){
        newGenButton.click();
    }

    /**
     * Méthode pour récupérer le mail généré.
     * @return Le texte avant le symbole "@" de l'adresse email générée.
     */
    public String getTextBeforeAt(){
        return beforeAt.getText();
    }

    /**
     * Méthode pour changer d'onglet dans le navigateur.
     * @param tabIndex L'index de l'onglet vers lequel changer.
     */
    public void goToTab(int tabIndex){
        Object[] windowHandles=webDriver.getWindowHandles().toArray();
        webDriver.switchTo().window((String) windowHandles[tabIndex]);
    }

    /**
     * Méthode pour cliquer sur le bouton pour accéder à la messagerie.
     */
    public void goToMail(){
        goToMailButton.click();
    }

    /**
     * Méthode pour cliquer sur le lien de réinitialisation du mot de passe.
     */
    public void clickPasswordResetLink(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10),Duration.ofSeconds(1));
        wait.until(Utils.frameToBeAvailableAndSwitchToIt(iframeMail));
        passwordResetLink.click();
    }

    /**
     * Méthode pour fermer la popup de la page YopMail.
     */
    public void dismissAdd(){
        webDriver.switchTo().frame(iframePopup);
        dismissButton.click();
        webDriver.switchTo().defaultContent();
    }

    /**
     * Méthode pour cliquer sur le bouton de rafraîchissement de la page YopMail.
     */
    public void clickRefreshButton(){
        refreshButton.click();
    }
}
