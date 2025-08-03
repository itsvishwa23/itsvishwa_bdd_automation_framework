package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.UICommonFunctions.waitForVisibility;

public class LoginPage {

    private  WebDriver driver;
    private Logger log;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        log= LogManager.getLogger(this.getClass().getName());
    }


    // Locators using @FindBy with XPath
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;

    // Actions

    public void navigateToLoginPage() {
        waitForVisibility(driver, usernameField, 10);
    }

    public void enterUidAndPass(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void validateDashboard() {
        waitForVisibility(driver,dashboardHeader , 10);
        Assert.assertTrue("Dashboard should be visible", dashboardHeader.isDisplayed());
    }
}
