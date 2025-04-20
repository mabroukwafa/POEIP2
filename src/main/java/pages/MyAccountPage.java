package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model (POM) pour la page Mon Compte.
 * Elle hérite de la classe {@link BasePage}.
*/
public class MyAccountPage extends BasePage{

    /**
    * Constructeur de la classe {@link BasePage} que la classe MyAccountPage hérite.
    * @param driver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public MyAccountPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(webDriver,this);
    }

    /*
    * Localisateur XPath pour le titre de la page Mon Compte.
     */
    @FindBy(xpath = "//h1[@class='page-heading' and text()='My account']")
    WebElement title;

    @FindBy(xpath = "//a[span[text()='My addresses']]")
    WebElement myAddressButton;

    @FindBy(xpath = "//a[@title='Home']")
    WebElement homeButton;

    @FindBy(xpath = "//a[@title='Information']")
    WebElement personalInformationButton;

    @FindBy(xpath = "//a[@title='Orders']")
    WebElement ordersButton;


    /*
     * Méthode pour récupérer le titre de la page Mon Compte.
     */
    public String getTitle(){
        return title.getText();
    }

    /**
     * Méthode pour cliquer sur le bouton "My addresses".
     */
    public void clickMyAddressButton(){
        myAddressButton.click();
    }

    /**
     * Méthode pour cliquer sur le bouton "Home".
     */
    public void clickHomeButton(){
        homeButton.click();
    }

    /**
     * Méthode pour cliquer sur le bouton "Orders".
     */
    public void clickOrderButton(){
        ordersButton.click();
    }

    /**
     * Méthode pour cliquer sur le bouton "Information".
     */
    public void clickPersonalInformationButton(){
        personalInformationButton.click();
    }

}
