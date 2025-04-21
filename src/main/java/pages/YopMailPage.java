package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @FindBy(xpath = "(//span[@class='genytxt'])[1]")
    WebElement beforeAt;

    @FindBy(xpath = "(//a)[2]")
    WebElement passwordResetLink;

    @FindBy(id = "refresh")
    WebElement refreshButton;

    @FindBy(id = "ifmail")
    WebElement iframeMail;

    @FindBy(id = "login")
    WebElement loginField;

    @FindBy(xpath = "//button[@class='md']")
    WebElement confirmationArrow;

    /**
     * Constructeur de la classe {@link BasePage} que la classe YopMailPage hérite.
     * @param webDriver le WebDriver utilisé pour interagir avec le navigateur
     */
    public YopMailPage(WebDriver webDriver){
        super(webDriver);
    }

    /**
     * Méthode pour ouvrir un nouvel onglet et accéder à la page YopMail.
     */
    public void goToYopMailGenerator(){
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get("https://yopmail.com/fr/email-generator");
    }

    /**
     * Méthode pour ouvrir un nouvel onglet et accéder à la page YopMail.
     */
    public void goToYopMailHomePage(){
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get("https://yopmail.com/fr");
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
     * Méthode pour cliquer sur le bouton pour accéder à la messagerie.
     */
    public void goToMail(){
        confirmationArrow.click();
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
     * Méthode pour cliquer sur le bouton de rafraîchissement de la page YopMail.
     */
    public void clickRefreshButton(){
        refreshButton.click();
    }

    public void enterLogin(String login){
        loginField.clear();
        loginField.sendKeys(login);
    }
}
