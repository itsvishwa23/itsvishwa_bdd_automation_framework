package stepDefinition;

import automationUtilities.BaseSteps;
import automationUtilities.BrowserFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectClasses.HomePage;
import pageObjectClasses.SignUpLoginPage;
import pageObjectClasses.UserHomePage;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class OpenLogInPageStepDef extends BaseSteps {
    //public static WebDriver driver;
    private HomePage homePage;
    private SignUpLoginPage signupLoginPage;
    private UserHomePage userHomepage;
    private BaseSteps baseSteps;
    private Logger log;
    private WebDriver driver= BrowserFactory.getDriverInstance();

    @Given("user navigates to the application")
    public void user_navigates_to_the_application() {
        log=LogManager.getLogger(this.getClass().getName());
        baseSteps = new BaseSteps();
        log.info("User trying to  navigate to application");
        baseSteps.openURL(driver);
        homePage = new HomePage(driver);
    }
    @When("user clicks on signup or login link")
    public void user_clicks_on_signup_or_login_link() {
        log.info("User  trying to click on log in link");
        homePage.clickSignUpOrLoginLink();

    }
}
