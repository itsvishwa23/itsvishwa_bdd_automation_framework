package stepDefination;

import utilities.BaseSteps;
import utilities.BrowserFactory;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class Login {
    private BaseSteps baseSteps;
    private Logger log;
    private WebDriver driver= BrowserFactory.getDriverInstance();

    private LoginPage loginpage  = new LoginPage(driver);

    @Given("User is on the OrangeHRM login page")
    public void user_is_on_login_page() {
        loginpage.navigateToLoginPage();
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginpage.enterUidAndPass(username, password);
    }

    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginpage.clickLoginButton();
    }

    @Then("User should be navigated to the dashboard")
    public void user_should_be_navigated_to_the_dashboard() {
        loginpage.validateDashboard();
    }
}
