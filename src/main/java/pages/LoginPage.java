package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    WebDriver driver;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    @FindBy(xpath = "//h1[@class='page-heading' and text()='Authentication']\n")
    WebElement title;

    @FindBy(xpath = "//input[@id = 'email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id = 'passwd']")
    WebElement passwdField;

    @FindBy(xpath = "//button[@id = 'SubmitLogin']")
    WebElement buttonSignIn ;

    @FindBy(xpath = "//input[@id = 'email_create']")
    WebElement emailCreateField;

    @FindBy(xpath = "//button[@id = 'submitAccount']")
    WebElement buttonCreateAccount2 ;

    @FindBy(xpath = "//button[@name = 'SubmitCreate']")
    WebElement buttonCreateAccount ;


    @FindBy(xpath = "//div[@id= 'create_account_error']")
    WebElement errorMessage ;



    public void sendEmail(String email){
        emailField.sendKeys(email);
    }

    public void sendPassword(String password){
        passwdField.sendKeys(password);
    }

    public void clickLoginButton(){
        buttonSignIn.click();
    }

    public void clickCreateAccountButton(){
         buttonCreateAccount.click();
    }
    public void clickCreateAccountButton2(){
        buttonCreateAccount2.click();
    }

    public void sendEmailCreate(String email){
        emailCreateField.sendKeys(email);
    }

    public String errorMessage(){
         return errorMessage.getText();
    }

    public String getTitle(){
         return title.getText();
    }

    public boolean titleIsDisplayed(){
        return title.isDisplayed();
    }



}
