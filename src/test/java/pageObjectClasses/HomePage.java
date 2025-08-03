package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class HomePage {
    private WebDriver driver;
    private Logger log;
    @FindBy(xpath = "//a[@href='/login']")
    @CacheLookup
    private WebElement signUpOrLogInLink;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        log=LogManager.getLogger(this.getClass().getName());
    }
    public void clickSignUpOrLoginLink(){
        signUpOrLogInLink.click();
        log.info("Clicked on SignUp Or Login Link");
    }
    /*public void verifySignUpOrLoginPageTitle(){
        if(driver.getTitle().equalsIgnoreCase(ExpectedPageTitle))
            System.out.println("SignUp Or Login page is displayed");
        else
            System.out.println("SignUp Or Login page is not displayed");
    }*/

}
