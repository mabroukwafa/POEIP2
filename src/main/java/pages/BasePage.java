package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    WebDriver  webDriver;
    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement logo;

    @FindBy(xpath = "//a[@class='login']")
     WebElement signIn;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOut;

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement fieldSearch;

    @FindBy(xpath = "//button[contains(@class, 'button-search')]")
    private WebElement loupeSearch;

    @FindBy(xpath = "//a[b='Cart']")
    private WebElement accessCart;

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement filtreWomen;

    @FindBy(xpath = "//a[@title='Dresses']")
    private WebElement filtreDresses;

    @FindBy(xpath = "//a[@title='T-shirts']")
    private WebElement filtreTShirts;


    @FindBy(xpath = "//a[@class='account']/span[text()='Valid valid']")
    private WebElement myName;


    @FindBy(xpath = "//a[text()='Blog']")
    private WebElement blogTab;

    @FindBy(xpath = "//a[@title='Contact us']")
    private WebElement contactUs;




    public void clickOnLogo(){
        logo.click();
    }
    public String getLogoText(){return logo.getText();}

    public  void clickOnSignIn(){
        signIn.click();
    }
    public  void clickOnSignOut(){
        signOut.click();
    }

    public void insertInFieldSearch(String string){
        fieldSearch.sendKeys(string);
    }

    public void clickOnLoupeSearch(){
        loupeSearch.click();
    }

    public void clickOnAccessCart(){
        accessCart.click();
    }

    public void clickOnFiltreWomen(){
        filtreWomen.click();
    }

    public void clickOnFiltreDresses(){
        filtreDresses.click();
    }

    public void clickOnFiltreTShirts(){
        filtreTShirts.click();
    }


    public String getMyname(){
        return myName.getText();
    }

    public void clickOnBlogTab(){
        blogTab.click();
    }
    public String getSignInText(){
        return signIn.getText();
    }

    public void clickOnContactUs(){
        contactUs.click();
    }








}
