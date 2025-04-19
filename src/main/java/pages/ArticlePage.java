package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object Model (POM) pour la page Article.
 * Elle hérite de la classe {@link BasePage}.
 */
public class ArticlePage extends BasePage {

    //Xpath
    @FindBy(xpath = "//h1[@itemprop='name']")
    WebElement article;

    /**
     * Constructeur de la classe {@link BasePage}} que la classe ArticlePage hérite
     * @param driver le WebDriver utilisé pour interagir avec le navigateur
     */
    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Récupère le nom de l'article affiché sur la page.
     * @return le nom de l'article.
     */
    public String getArticleName() {
        return article.getText();
    }


}
