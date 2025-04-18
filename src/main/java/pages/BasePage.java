package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * BasePage est une classe qui est parente de toutes les autres pages.
 * Elle contient les éléments et les méthodes communes à toutes les pages.
 */
public class BasePage {

    /**
     * Le constructeur de la classe BasePage.
     * @param webDriver instance de WebDriver pour interagir avec le navigateur
     */
    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    WebDriver  webDriver;

    /**
     * Localisateur XPath pour le logo de la page d'accueil.
     */
    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement logo;

    @FindBy(xpath = "//a[@class='login']")
    WebElement signIn;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOut;

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement fieldSearch;

    @FindBy(xpath = "//button[contains(@class, 'button-search')]")
    private WebElement loupeSearch;

    @FindBy(xpath = "//a[@title=\"View my shopping cart\"]/b[text()=\"Cart\"]\n")
    private WebElement accessCart;

    @FindBy(xpath = "//div[@id = 'block_top_menu']/ul/li[1]/a")
    private WebElement filtreWomen;

    @FindBy(xpath = "//div[@id = 'block_top_menu']/ul/li[2]/a")
    private WebElement filtreDresses;

    @FindBy(xpath = "//div[@id = 'block_top_menu']/ul/li[3]/a")
    private WebElement filtreTShirts;


    @FindBy(xpath = "//a[@class='account']/span[text()='Valid valid']")
    private WebElement myName;


    @FindBy(xpath = "//a[text()='Blog']")
    private WebElement blogTab;

    @FindBy(xpath = "//a[@title='Contact us']")
    private WebElement contactUs;

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
    public void insertInFieldSearch(String string){
        fieldSearch.sendKeys(string);
    }

    /**
     * Méthode pour vérifier si le champ de recherche est visible.
     * @return vrai si le champ de recherche est affiché, faux sinon
     */
    public Boolean isFieldSearchVisible(){
        return fieldSearch.isDisplayed();
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
    public void clickOnFiltreWomen(){
        filtreWomen.click();
    }

    /**
     * Méthode pour cliquer sur l'élément de filtre pour les robes.
     */
    public void clickOnFiltreDresses(){
        filtreDresses.click();
    }

    /**
     * Méthode pour cliquer sur l'élément de filtre pour les T-shirts.
     */
    public void clickOnFiltreTShirts(){
        filtreTShirts.click();
    }

    /**
     * Méthode pour obtenir le nom de l'utilisateur connecté.
     * @return le texte du nom d'utilisateur
     */
    public String getMyname(){
        return myName.getText();
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

}