package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Page Object Model (POM) pour la page de recherche.
 * Elle hérite de la classe {@link BasePage}.
 */
public class SearchPage extends BasePage{

    //Xpath
    @FindBy(xpath = "//ul[@class='product_list grid row']//a[@class='product-name']")
    List<WebElement> productList;


    @FindBy(xpath = "//h1[@class='page-heading  product-listing']")
    WebElement currentPageName;

    /**
     * Constructeur de la classe {@link BasePage} que la classe SearchPage hérite.
     * @param webDriver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public SearchPage(WebDriver webDriver){
        super(webDriver);
    }

    /**
     * Vérifie si un produit est visible sur la page de recherche.
     *
     * @param productName Le nom du produit à rechercher
     * @return true si le produit est visible, false sinon
     */
    public Boolean isProductVisible(String productName){
        for (WebElement product:productList){
            if (product.getText().contains(productName)) return true;
        }
        return false;
    }

    /**
     * Vérifie si la page actuelle est la page de recherche.
     *
     * @return true si la page actuelle est la page de recherche, false sinon
     */
    public Boolean beOnSearchPage(){
        System.out.println(currentPageName.getText());
        return currentPageName.getText().toLowerCase().contains("search");
    }

}
