package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    WebDriver webDriver;

    public HomePage(WebDriver driver){
        super(driver);
    }
}
