package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object Model (POM) pour la page Article.
 * Elle hérite de la classe {@link BasePage}.
 */
public class ArticlePage extends BasePage{

        @FindBy(xpath = "//h1[@itemprop='name']")
        WebElement article;

        public ArticlePage(WebDriver driver){
            super(driver);
        }

        public String getArticleName(){
            return article.getText();
        }


}
