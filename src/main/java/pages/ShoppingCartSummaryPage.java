package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
 * Page Object Model (POM) pour la page de résumé du panier d'achat.
 * Cette classe représente les éléments et les interactions possibles sur la page ShoppingCartSummary.
 */
public class ShoppingCartSummaryPage extends BasePage {

    /*
     * Constructeur de la classe BasePage que la classe ShoppingCartSummaryPage hérite.
     * @param driver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public ShoppingCartSummaryPage(WebDriver driver){
        super(driver);
    }

    /*
     * Localisateur XPath
     */
    @FindBy(xpath = " //div[@id='center_column']//h1[@id='cart_title']")
    WebElement title;

    /*
     * Méthode pour récupérer le titre de la page de résumé du panier d'achat.
     */
    public String getTitle(){
        return title.getText();
    }


}
