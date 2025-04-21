package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object Model (POM) pour la page de résumé du panier d'achat.
 * Elle hérite de la classe {@link BasePage}.
 */
public class ShoppingCartSummaryPage extends BasePage {

    @FindBy(xpath = " //div[@id='center_column']//h1[@id='cart_title']")
    WebElement title;

    /**
     * Constructeur de la classe {@link BasePage} que la classe ShoppingCartSummaryPage hérite.
     * @param webDriver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public ShoppingCartSummaryPage(WebDriver webDriver){
        super(webDriver);
    }

    /**
     * Méthode pour récupérer le titre de la page de résumé du panier d'achat.
     */
    public String getTitle(){
        return title.getText();
    }


}
