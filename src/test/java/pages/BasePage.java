package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[data-qa='logo-wrapper']")
    public WebElement logo;

    @FindBy(id = "div[data-qa='navigation-wrapper']>div>a")
    public List<WebElement> navigationOptions;

    @FindBy(css = "div[data-qa='desktop-wrapper']>a")
    public WebElement signInLink;

    @FindBy(css = "div.pages_container__2pegi>div>p")
    public WebElement signModal;

    @FindBy(css = "input[data-qa='sign-in-email']")
    public WebElement emailInputBox;

    @FindBy(css = "input[type='password'] ")
    public WebElement passwordInputBox;

    @FindBy(id = "button[data-testid='Button']")
    public WebElement modalSighInButton;

    @FindBy(id = "#error-banner")
    public WebElement errorMessage;

    @FindBy(css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchCarLink;



}

