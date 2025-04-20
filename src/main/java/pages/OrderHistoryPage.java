package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends BasePage{
    public OrderHistoryPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='page-heading bottom-indent']\n")
    WebElement pageTitle;

    public String pageTitle(){
    return pageTitle.getText();
    }
}




