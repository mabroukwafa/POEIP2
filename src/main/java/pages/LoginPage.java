package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model (POM) pour la page de connexion.
    * Elle hérite de la classe {@link BasePage}.
 */
public class LoginPage extends BasePage{

    /**
     * Constructeur de la classe BasePage que la classe LoginPage hérite.
     * @param driver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public LoginPage(WebDriver driver){
        super(driver);
    }


    /**
     * Localisateur XPath
     */
    @FindBy(xpath = "//h1[@class='page-heading' and text()='Authentication']\n")
    WebElement title;

    @FindBy(xpath = "//input[@id = 'email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id = 'passwd']")
    WebElement passwdField;

    @FindBy(xpath = "//button[@id = 'SubmitLogin']")
    WebElement buttonSignIn ;

    @FindBy(xpath = "//input[@id = 'email_create']")
    WebElement emailCreateField;

    @FindBy(xpath = "//button[@id = 'submitAccount']")
    WebElement buttonCreateAccount2 ;

    @FindBy(xpath = "//button[@name = 'SubmitCreate']")
    WebElement buttonCreateAccount ;


    @FindBy(xpath = "//div[@id= 'create_account_error']")
    WebElement errorMessage ;

    @FindBy(xpath = "//a[@href='http://www.automationpractice.pl/index.php?controller=password']")
    WebElement ForgotPassword ;


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
        passwdField.sendKeys(password);
    }

    /**
     * Clique sur le bouton de connexion.
     */
    public void clickLoginButton(){
        buttonSignIn.click();
    }

    /**
     * Clique sur le bouton de création de compte.
     */
    public void clickCreateAccountButton(){
         buttonCreateAccount.click();
    }
    public void clickCreateAccountButton2(){
        buttonCreateAccount2.click();
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
    public String errorMessage(){
         return errorMessage.getText();
    }

    /**
     * Récupère le titre de la page.
     * @return Le titre de la page
     */
    public String getTitle(){
         return title.getText();
    }

    /**
     * Clique sur le lien de mot de passe oublié.
     */
    public void clickForgotPassword(){
          ForgotPassword.click();
    }

    /**
     * Vérifie si le titre de la page est affiché.
     * @return true si le titre est affiché, false sinon
     */
    public boolean titleIsDisplayed(){
        return title.isDisplayed();
    }




}
