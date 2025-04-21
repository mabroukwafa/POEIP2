package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath ="(//input[@id='email']/..)[contains(@class,'error')]")
    WebElement formErrorOnEmailField;

    @FindBy(xpath ="(//input[@id='email']/..)[contains(@class,'ok')]")
    WebElement formCheckOnEmailField;

    @FindBy(id = "id_gender1")
    public WebElement genderMrRadio;

    @FindBy(id = "id_gender2")
    public WebElement genderMrsRadio;

    @FindBy(id = "customer_firstname")
    public WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    public WebElement lastNameInput;

    @FindBy(id = "passwd")
    public WebElement passwordField;

    @FindBy(xpath ="(//input[@id='passwd']/..)[contains(@class,'error')]")
    WebElement formErrorOnPasswordField;

    @FindBy(xpath ="(//input[@id='passwd']/..)[contains(@class,'ok')]")
    WebElement formCheckOnPasswordField;

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

    @FindBy(xpath = "//h1[@class = 'page-heading' and contains(text(),'C')]")
    WebElement pageTitle;

    @FindBy(xpath = "//h3")
    WebElement subtitle;


    /**
     * Méthode pour entrer l'email pour créer un compte.
     * Cette méthode remplit le champ d'email et clique sur le bouton de création de compte.
     * Après avoir nettoyé le champ d'email.
     * @param email L'email à entrer dans le champ de création de compte.
     */
    public void enterEmailToCreateAccount(String email) {
        reinitElements();
        emailCreateField.clear();
        emailCreateField.sendKeys(email);
        reinitElements();
        subtitle.click();
    }

    /**
     * Méthode pour entrer le mot de passe pour créer un compte.
     * Cette méthode remplit le champ de mot de passe et clique sur le sous-titre afin de
     * faire apparaître la croix ou le check.
     * @param password Le mot de passe à entrer dans le champ de création de compte.
     */
    public void enterPasswordToCreateAccount(String password){
        reinitElements();
        passwordField.clear();
        passwordField.sendKeys(password);
        reinitElements();
        subtitle.click();
    }

    /**
     * Méthode pour cliquer sur le bouton "Register".
     */
    public void clickRegister() {
        registerButton.click();
    }

    /**
     * Méthode pour sélectionner le genre.
     * @param gender Le genre à sélectionner ("Mr" ou "Mrs").
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
        passwordField.sendKeys(password);
        if (newsletter.equalsIgnoreCase("yes")) newsletterCheckbox.click();
        chooseSelectionByValue(dayDropdown,days);
        chooseSelectionByValue(monthDropdown,months);
        chooseSelectionByValue(yearDropdown,years);
        selectGender(gender);
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
        passwordField.sendKeys(password);


    }

    /**
     * Méthode pour récupérer le texte du titre de la page.
     * @return Le texte du titre de la page.
     */
    public String getPageTitle(){
        return pageTitle.getText();
    }


    /**
     * Méthode permettant de savoir si le champ email ou mot de passe affiche une check ou une croix
     * @return un booléen indiquant si le champ email ou mot de passe affiche une check ou une croix
     */
    public Boolean isFieldCheckOrErrorVisible(String field, String status){
        if (field.equalsIgnoreCase("email")){
            if (status.equalsIgnoreCase("correct")) return formCheckOnEmailField.isDisplayed();
            else return formErrorOnEmailField.isDisplayed();
        }
        else{
            if (status.equalsIgnoreCase("correct")) return formCheckOnPasswordField.isDisplayed();
            else return formErrorOnPasswordField.isDisplayed();
        }
    }

}
