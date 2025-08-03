package pageObjectClasses;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UserHomePage {
    private WebDriver driver;
    private Logger log;
    private boolean flag;
    private String ExpectedPageTitle="Automation Exercise";
    @FindBy(xpath = "//a[@href='/logout']")
    @CacheLookup
    private WebElement logoutLink;
    public UserHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        log=LogManager.getLogger(this.getClass().getName());
    }
    public boolean verifyUserHomepagePageTitle(){
        if(driver.getTitle().equalsIgnoreCase(ExpectedPageTitle)) {
            log.info("User Home page is displayed");
            flag=true;
        }
        else {
            System.out.println("User Home page is not displayed");
            flag=false;
        }
        return flag;
    }
    public void clickLogoutLink(){
        logoutLink.click();
        log.info("Clicked on logout link");
    }

}
