package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object Model (POM) pour la page de connexion.
    * Elle hérite de la classe {@link BasePage}.
 */
public class LoginPage extends BasePage{

    /**
     * Constructeur de la classe {@link BasePage} que la classe LoginPage hérite.
     * @param webDriver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }


    /**
     * Localisateurs
     */
    @FindBy(xpath = "//h1[@class='page-heading' and text()='Authentication']\n")
    WebElement title;

    @FindBy(xpath = "//input[@id = 'email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id = 'passwd']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@id = 'SubmitLogin']")
    WebElement signInButton;

    @FindBy(xpath = "//input[@id = 'email_create']")
    WebElement emailCreateField;

    @FindBy(xpath = "//button[@name = 'SubmitCreate']")
    WebElement createAccountButton;

    @FindBy(xpath = "//div[@class= 'alert alert-danger']/ol/li")
    WebElement loginErrorMessage ;

    @FindBy(xpath = "//div[@id= 'create_account_error']/ol/li")
    WebElement createAccountErrorMessage ;

    @FindBy(xpath = "//a[@href='http://www.automationpractice.pl/index.php?controller=password']")
    WebElement forgotPasswordLink;


    /**
     * Insère l'email dans le champ de saisie associé.
     * @param email L'email à insérer
     */
    public void sendEmail(String email){
        emailField.sendKeys(email);
    }

    /**
     * Insère le mot de passe dans le champ de saisie associé.
     * @param password Le mot de passe à insérer
     */
    public void sendPassword(String password){
        passwordField.sendKeys(password);
    }

    /**
     * Clique sur le bouton de connexion.
     */
    public void clickLoginButton(){
        signInButton.click();
    }

    /**
     * Clique sur le bouton de création de compte.
     */
    public void clickCreateAccountButton(){
         createAccountButton.click();
    }

    /**
     * Insère l'email dans le champ associé.
     * @param email L'email à insérer
     */
    public void sendEmailCreate(String email){
        emailCreateField.sendKeys(email);
    }

    /**
     * Récupère le message d'erreur affiché.
     * @return Le message d'erreur
     */
    public String getLoginErrorMessage(){
         return loginErrorMessage.getText();
    }

    /**
     * Vérifie si un message d'erreur est affiché.
     * @return Le message d'erreur est-il affiché ou non
     */
    public Boolean isCreateAccountErrorMessageVisible(){
        return createAccountErrorMessage.isDisplayed();
    }

    /**
     * Clique sur le lien de mot de passe oublié.
     */
    public void clickForgotPassword(){
          forgotPasswordLink.click();
    }

    /**
     * Vérifie si le titre de la page est affiché.
     * @return true si le titre est affiché, false sinon
     */
    public boolean titleIsDisplayed(){
        return title.isDisplayed();
    }




}
