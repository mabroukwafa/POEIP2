package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

public class YopMailPage extends BasePage {

    @FindBy(xpath = "//button[@aria-label='Autoriser']")
    WebElement authorizeButton;

    @FindBy(xpath = "//button[@onclick='newgen();']")
    WebElement newGenButton;

    @FindBy(xpath = "//button[@onclick='egengo();']")
    WebElement goToMailButton;

    @FindBy(xpath = "(//span[@class='genytxt'])[1]")
    WebElement beforeAt;

    @FindBy(xpath = "//a[contains(@href,'passw')]")
    WebElement passwordResetLink;

    @FindBy(id = "aswift_3")
    WebElement iframePopup;

    @FindBy(id = "dismiss-button")
    WebElement dismissButton;

    @FindBy(id = "refresh")
    WebElement refreshButton;

    @FindBy(id = "ifmail")
    WebElement iframeMail;

    public YopMailPage(WebDriver driver){
        super(driver);
    }

    public void goToYopMailGenerator(){
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get("https://yopmail.com/fr/email-generator");
    }

    public void clickAuthorizeButton(){
        authorizeButton.click();
    }

    public void clickNewGenButton(){
        newGenButton.click();
    }

    public String getTextBeforeAt(){
        return beforeAt.getText();
    }

    public void goToTab(int tabIndex){
        Object[] windowHandles=webDriver.getWindowHandles().toArray();
        webDriver.switchTo().window((String) windowHandles[tabIndex]);
    }

    public void goToMail(){
        goToMailButton.click();
    }

    public void clickPasswordResetLink(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10),Duration.ofSeconds(1));
        wait.until(Utils.frameToBeAvailableAndSwitchToIt(iframeMail));
        passwordResetLink.click();
    }

    public void dismissAdd(){
        webDriver.switchTo().frame(iframePopup);
        dismissButton.click();
        webDriver.switchTo().defaultContent();
    }

    public void clickRefreshButton(){
        refreshButton.click();
    }
}
