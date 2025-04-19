package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Page Object Model (POM) pour la page de création de compte.
 * Elle hérite de la classe {@link BasePage}.
 */
public class CreateAccountPage extends BasePage {

    /**
     * Constructeur de la classe {@link BasePage} que la classe CreateAccountPage hérite.
     * @param driver le WebDriver utilisé pour interagir avec le navigateur
     */
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }


    //Xpath
    @FindBy(xpath = "//input[@id = 'email']")
    WebElement emailCreateField;

    @FindBy(xpath = "//button[@name = 'SubmitCreate']")
    WebElement buttonCreateAccount ;

    @FindBy(id = "id_gender1")
    public WebElement genderMrRadio;

    @FindBy(id = "id_gender2")
    public WebElement genderMrsRadio;

    @FindBy(id = "customer_firstname")
    public WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    public WebElement lastNameInput;

    @FindBy(id = "passwd")
    public WebElement enterPassword;

    @FindBy(id = "days")
    public WebElement dayDropdown;

    @FindBy(id = "months")
    public WebElement monthDropdown;

    @FindBy(id = "years")
    public WebElement yearDropdown;

    @FindBy(id = "newsletter")
    public WebElement newsletterCheckbox;


    @FindBy(id = "submitAccount")
    public WebElement registerButton;


    /**
     * Méthode pour entrer l'email pour créer un compte.
     * Cette méthode remplit le champ d'email et clique sur le bouton de création de compte.
     * Après avoir nettoyé le champ d'email.
     * @param email L'email à entrer dans le champ de création de compte.
     */
    public void enterEmailToCreateAccount(String email) {
        emailCreateField.clear();
        emailCreateField.sendKeys(email);
        buttonCreateAccount.click();
    }

    /**
     * Méthode pour cliquer sur le bouton "Create an account".
     */
    public void clickCreateAccountButton() {
        buttonCreateAccount.click(); // Cette ligne clique sur le bouton "Create an account"
    }

    /**
     * Méthode pour cliquer sur le bouton "Register".
     */
    public void clickRegister() {
        registerButton.click();
    }

    /**
     * Méthode pour sélectionner le genre.
     * @param gender Le genre à sélectionné ("Mr" ou "Mrs").
     */
    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Mr")) {
            genderMrRadio.click();
        } else if (gender.equalsIgnoreCase("Mrs")) {
            genderMrsRadio.click();
        }
    }

    /**
     * Méthode pour remplir les détails de base du compte de l'utilisateur.
     * @param firstName prénom de l'utilisateur
     * @param lastName nom de l'utilisateur
     * @param password mot de passe de l'utilisateur
     * @param newsletter abonnement à la newsletter
     * @param gender genre de l'utilisateur
     * @param days jour de naissance de l'utilisateur
     * @param months mois de naissance de l'utilisateur
     * @param years année de naissance de l'utilisateur
     */
    public void fillBasicAccountDetails(String firstName, String lastName, String password,
                                        String newsletter, String gender, String days, String months, String years) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        enterPassword.sendKeys(password);
        newsletterCheckbox.sendKeys(newsletter);
        genderMrRadio.click();
        dayDropdown.sendKeys(days);
        monthDropdown.sendKeys(months);
        yearDropdown.sendKeys(years);

    }

    /**
     * Méthode pour remplir les champs obligatoires du compte de l'utilisateur.
     * @param firstName prénom de l'utilisateur
     * @param lastName nom de l'utilisateur
     * @param password mot de passe de l'utilisateur
     */
    public void fillrequired(String firstName, String lastName, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        enterPassword.sendKeys(password);


    }


//    public void subscribeToNewsletter() {
//        WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
//        if (!newsletterCheckbox.isSelected()) {
//            newsletterCheckbox.click();
//        }
//    }

    /*
     * Méthode pour cliquer sur le bouton "Register".
     */
    public void clickRegisterButton() {
        registerButton.click();
    }

}
