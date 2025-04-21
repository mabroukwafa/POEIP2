package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object Model (POM) pour la page d'informations personnelles.
 * Elle hérite de la classe {@link BasePage}.
 */
public class PersonalInformationPage extends BasePage{

    /**
     * Constructeur de la classe {@link BasePage} que la classe PersonalInformationPage hérite.
     * @param webDriver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public PersonalInformationPage(WebDriver webDriver){
        super(webDriver);
    }


    @FindBy(xpath = "//h1[@class='page-subheading']")
    WebElement pageTitle;


    /**
     * Méthode pour récupérer le titre de la page d'informations personnelles.
     *
     * @return Le texte du titre de la page
     */
    public String getTitle(){
       return pageTitle.getText();
    }


}
