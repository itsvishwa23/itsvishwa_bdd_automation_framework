package hooks;

import utilities.BaseSteps;
import utilities.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private BrowserFactory browserFactory;
    private WebDriver driver;
    @Before
    public void setUp(){
        browserFactory = new BrowserFactory();
        driver = browserFactory.browserSetup();
        BaseSteps baseSteps = new BaseSteps();
        baseSteps.openURL(driver);
    }
   @After(order=0)
    public void tearDown(){
        driver.quit();
       System.out.println("In Tear down method");
   }
@After(order=1)
    public void takeScreenshot(Scenario scenario){
        String screenShotName=scenario.getName().toUpperCase().replaceAll(" ","_");
    byte[] srcLocation=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    if(scenario.isFailed()) {
        scenario.attach(srcLocation, "image/png", screenShotName);
    }
}
}
