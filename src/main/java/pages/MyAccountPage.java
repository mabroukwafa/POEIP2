package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='page-heading' and text()='My account']")
    WebElement title;


    public String getTitle(){
        return title.getText();
    }

}
