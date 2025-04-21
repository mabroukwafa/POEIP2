package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model (POM) pour la page Prestashop.
 */
public class PrestashopPage {

    @FindBy(xpath = "//h1[@class='color-3 t0--5 t0 title']")
    WebElement prestashopTitle;

    WebDriver webDriver;

    /**
     * Constructeur de la classe PrestashopPage.
     * Initialise les éléments de la page avec PageFactory.
     *
     * @param webDriver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public PrestashopPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    /**
     * Vérifie si le titre de la page Prestashop est affiché.
     *
     * @return true si le titre est visible, false sinon
     */
    public boolean isPrestashopTitleDisplayed(){
        return prestashopTitle.isDisplayed();
    }
}