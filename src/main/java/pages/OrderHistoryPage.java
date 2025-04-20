package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object Model (POM) pour la page d'historique des commandes.
 * Elle hérite de la classe {@link BasePage}.
 */
public class OrderHistoryPage extends BasePage{

    /**
     * Constructeur de la classe {@link BasePage} que la classe OrderHistoryPage hérite.
     * @param driver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public OrderHistoryPage(WebDriver driver){
        super(driver);
    }

    //Xpath
    @FindBy(xpath = "//h1[@class='page-heading bottom-indent']\n")
    WebElement pageTitle;

    /**
     * Méthode pour récupérer le titre de la page d'historique des commandes.
     * @return Le titre de la page d'historique des commandes
     */
    public String pageTitle(){
    return pageTitle.getText();
    }
}




