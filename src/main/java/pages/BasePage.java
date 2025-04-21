package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * BasePage est une classe qui est parente de toutes les autres pages.
 * Elle contient les éléments et les méthodes communes à toutes les pages.
 */
public class BasePage {

    WebDriver  webDriver;
    /**
     * Constructeur de la classe {@link BasePage} .
     * @param webDriver instance de WebDriver pour interagir avec le navigateur
     */
    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement logo;

    @FindBy(xpath = "//a[@class='login']")
    WebElement signIn;

    @FindBy(xpath = "//a[@class='logout']")
    WebElement signOut;

    @FindBy(xpath = "//input[@id='search_query_top']")
    WebElement searchField;

    @FindBy(xpath = "//button[contains(@class, 'button-search')]")
    WebElement loupeSearch;

    @FindBy(xpath = "//a[@title=\"View my shopping cart\"]/b[text()=\"Cart\"]\n")
    WebElement accessCart;

    @FindBy(xpath = "//div[@id = 'block_top_menu']/ul/li[1]/a")
    WebElement womenFilter;

    @FindBy(xpath = "//div[@id = 'block_top_menu']/ul/li[2]/a")
    WebElement dressesFilter;

    @FindBy(xpath = "//div[@id = 'block_top_menu']/ul/li[3]/a")
    WebElement tShirtsFilter;


    @FindBy(xpath = "//a[@class='account']/span[text()='Valid valid']")
    WebElement connectedAccountName;


    @FindBy(xpath = "//a[text()='Blog']")
    WebElement blogTab;

    @FindBy(xpath = "//a[@title='Contact us']")
    WebElement contactUs;

    @FindBy(xpath = "//div[@class='ac_results']/ul/li")
    List<WebElement> suggestionsList;


    /**
     * Méthode pour cliquer sur l'élément logo.
     */
    public void clickOnLogo(){
        logo.click();
    }

    /**
     * Méthode pour cliquer sur l'élément de connexion.
     */
    public  void clickOnSignIn(){
        signIn.click();
    }

    /**
     * Méthode pour cliquer sur l'élément de déconnexion.
     */
    public  void clickOnSignOut(){
        signOut.click();
    }

    /**
     * Méthode pour insérer une chaîne de caractères dans le champ de recherche.
     * @param string chaîne de caractères à insérer dans le champ de recherche
     */
    public void insertInSearchField(String string){
        searchField.sendKeys(string);
    }

    /**
     * Méthode pour vérifier si le champ de recherche est visible.
     * @return vrai si le champ de recherche est affiché, faux sinon
     */
    public Boolean isSearchFieldVisible(){
        return searchField.isDisplayed();
    }

    /**
     * Méthode pour choisir une suggestion dans la liste des suggestions.
     * @param suggestion chaîne de caractères représentant la suggestion à choisir
     */
    public void chooseSuggestion(String suggestion){
        for (WebElement suggestionElement:suggestionsList){
            if (suggestionElement.getText().contains(suggestion)) suggestionElement.click();

        }
    }

    /**
     * Méthode pour cliquer sur l'élément de recherche (loupe).
     */
    public void clickOnLoupeSearch(){
        loupeSearch.click();
    }

    /**
     * Méthode pour cliquer sur l'élément d'accès au panier.
     */
    public void clickOnAccessCart(){
        accessCart.click();
    }

    /**
     * Méthode pour cliquer sur l'élément de filtre pour les femmes.
     */
    public void clickOnWomenFilter(){
        womenFilter.click();
    }

    /**
     * Méthode pour cliquer sur l'élément de filtre pour les robes.
     */
    public void clickOnDressesFilter(){
        dressesFilter.click();
    }

    /**
     * Méthode pour cliquer sur l'élément de filtre pour les T-shirts.
     */
    public void clickOnTShirtsFilter(){
        tShirtsFilter.click();
    }

    /**
     * Méthode pour obtenir le nom de l'utilisateur connecté.
     * @return le texte du nom d'utilisateur
     */
    public String getConnectedAccountName(){
        return connectedAccountName.getText();
    }

    /**
     * Méthode pour cliquer sur l'onglet "Blog".
     */
    public void clickOnBlogTab(){
        blogTab.click();
    }

    /**
     * Méthode pour obtenir le texte de l'élément de connexion.
     * @return le texte de l'élément de connexion
     */
    public String getSignInText(){
        return signIn.getText();
    }

    /**
     * Méthode pour cliquer sur l'élément "Contact us".
     */
    public void clickOnContactUs(){
        contactUs.click();
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
     * Méthode permettant d'initialiser à nouveau les éléments d'une page
     */
    public void reinitElements(){
        PageFactory.initElements(webDriver,this);
    }

    /**
     * Méthode permettant de fermer l'onglet actif
     */
    public void closeTab(){
        webDriver.close();
    }

    /**
     * Méthode permettant de choisir une proposition dans un select à partir de son nom
     * @param selectElement Le select contenant les propositions
     * @param text Le nom de la proposition à choisir
     */
    public void chooseSelectionByVisibleText(WebElement selectElement,String text){
        Select select = new Select(selectElement);
        select.selectByVisibleText(text);
    }

    /**
     * Méthode permettant de choisir une proposition dans un select à partir de sa valeur
     * @param selectElement Le select contenant les propositions
     * @param value La valeur de la proposition à choisir
     */
    public void chooseSelectionByValue(WebElement selectElement,String value){
        Select select = new Select(selectElement);
        select.selectByValue(value);
    }
}