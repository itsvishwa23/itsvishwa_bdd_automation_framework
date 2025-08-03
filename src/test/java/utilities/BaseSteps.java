package utilities;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.util.Properties;

public class BaseSteps {
    //public static WebDriver driver;
    private Properties prop;
    private String applicationURL;
    private String browser;
    private Logger log;


    public void openURL(WebDriver driver) {
        prop = new Properties();
        try {
            log = LogManager.getLogger(this.getClass().getName());
            prop.load(BaseSteps.class.getClassLoader().getResourceAsStream("configuration.properties"));
            applicationURL = prop.getProperty("appURL");
            driver.get(applicationURL);
            driver.manage().window().maximize();
            log.info("Navigated to application");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}