package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCreditSlipsPage extends BasePage{

    public MyCreditSlipsPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(xpath = "//h1[@class='page-heading bottom-indent']")
    WebElement pageTitle;

    public String pageTitle(){
        return pageTitle.getText();
    }
}
