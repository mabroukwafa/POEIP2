package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    WebDriver webDriver;

    @FindBy(xpath = "(//img[contains(@src, 'banner-img')])[1]")
    private WebElement advertisement;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickOnAdvertisement(){
        advertisement.click();
    }


}
