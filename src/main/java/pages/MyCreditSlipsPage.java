package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object Model (POM) pour la page des avoirs.
 * Elle hérite de la classe {@link BasePage}.
 */
public class MyCreditSlipsPage extends BasePage{

    /**
     * Constructeur de la classe {@link BasePage} que la classe MyCreditSlipsPage hérite.
     * @param webDriver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public MyCreditSlipsPage(WebDriver webDriver){
        super(webDriver);
    }

    //XPath
    @FindBy(xpath = "//h1[@class='page-heading bottom-indent']")
    WebElement pageTitle;

    /**
     * Méthode pour récupérer le titre de la page des avoirs.
     * @return Le texte du titre de la page
     */
    public String pageTitle(){
        return pageTitle.getText();
    }
}
