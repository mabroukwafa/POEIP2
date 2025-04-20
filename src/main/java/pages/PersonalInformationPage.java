package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInformationPage extends BasePage{
    public PersonalInformationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='page-subheading']")
    WebElement pageTitle;


    public String getTitle(){
       return pageTitle.getText();
    }


}
