package hooks;

import utilities.BaseSteps;
import utilities.BrowserFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.UICommonFucntions;

public class Hooks {
    private BrowserFactory browserFactory;
    private WebDriver driver;
    private UICommonFucntions UICommonFun ;

    @Before
    public void setUp() {
        browserFactory = new BrowserFactory();
        driver = browserFactory.browserSetup();
        BaseSteps baseSteps = new BaseSteps();
        baseSteps.openURL(driver);
    }

    public void cleanUpBeforeScenario() {
        UICommonFun.deleteAllFiles("test-output");
    }

    @After(order = 0)
    public void tearDown() {
        driver.quit();
        System.out.println("In Tear down method");
    }

    @AfterStep
    public void takeScreenshotAfterEachStep(Scenario scenario) {
        String screenShotName = scenario.getName().toUpperCase().replaceAll(" ", "_") + "_STEP";
        String currentUrl = driver.getCurrentUrl();
        byte[] srcLocation = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.log("URL at this step: " + currentUrl);
        scenario.attach(srcLocation, "image/png", screenShotName);
    }


}
