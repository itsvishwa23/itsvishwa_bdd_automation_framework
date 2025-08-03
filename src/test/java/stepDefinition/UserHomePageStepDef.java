package stepDefinition;

import automationUtilities.BaseSteps;
import automationUtilities.BrowserFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjectClasses.HomePage;
import pageObjectClasses.SignUpLoginPage;
import pageObjectClasses.UserHomePage;

import java.util.List;
import java.util.Map;

public class UserHomePageStepDef extends BaseSteps {
    //public static WebDriver driver;
    //private HomePage homePage;
   // private SignUpLoginPage signupLoginPage;
    private UserHomePage userHomepage;
    private BaseSteps baseSteps;
    private Logger log;
    private WebDriver driver= BrowserFactory.getDriverInstance();
    @Then("application should navigate to logged in user home page")
    public void applicationShouldNavigateToLoggedInUserHomePage() {
        log=LogManager.getLogger(this.getClass().getName());
        log.info("User is verifying application is navigated to user Home Page");
        userHomepage=new UserHomePage(driver);
        Assert.assertTrue(userHomepage.verifyUserHomepagePageTitle());
    }
    @And("user clicks on logout link")
    public void userClicksOnLogoutLink() {
        log.info("User is trying to click on logout link");
        userHomepage.clickLogoutLink();
    }
}
