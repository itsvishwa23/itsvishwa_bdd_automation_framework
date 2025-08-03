package pageObjectClasses;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SignUpLoginPage {
    private WebDriver driver;
    private Logger log;
    private boolean flag;
    private String ExpectedPageTitle="Automation Exercise - Signup / Login";
    @FindBy(xpath = "//input[@data-qa='login-email']")
    @CacheLookup
    private WebElement emailIdTextBox;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    @CacheLookup
    private WebElement passwordTextBox;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    @CacheLookup
    private WebElement loginButton;
    public SignUpLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        log=LogManager.getLogger(this.getClass().getName());
    }
    public void enterUserName(String userName){
        emailIdTextBox.sendKeys(userName);
       log.info("Entered User name as :"+userName);
    }
    public void enterPassword(String password){
        passwordTextBox.sendKeys(password);
        log.info("Entered password is  :"+password);
    }
    public void clickLoginButton(){
        loginButton.click();
        log.info("Clicked on login button");
    }
    public Boolean verifySignUpOrLoginPageTitle(){
        if(driver.getTitle().equalsIgnoreCase(ExpectedPageTitle)) {
            log.info("SignUp Or Login page is displayed");
            flag=true;
        }
        else{
            log.info("SignUp Or Login page is not displayed");
            flag=true;
        }

        return flag;
    }

}
