package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordResetPage extends BasePage{

    public PasswordResetPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='page-subheading' and text()='Forgot your password?']")
    WebElement title;

    @FindBy(xpath = "//input[@id='email' and @name='email']")
    WebElement emailField;

    @FindBy(xpath = "//button[@type='submit']//span[contains(text(), 'Retrieve Password')]\n")
    WebElement buttonRetrievePassword;

    @FindBy(xpath = "//p[contains(@class, 'alert-success') and contains(text(), 'confirmation email has been sent')]\n")
    WebElement ConfirmationMessage;

    public String getTitle(){
        return title.getText();
    }
    public String getConfirmationMessage(){
        return ConfirmationMessage.getText();
    }
    public void sendEmail(String email){
        emailField.sendKeys(email);
    }
    public void clickButton(){
            buttonRetrievePassword.click();
    }


}
