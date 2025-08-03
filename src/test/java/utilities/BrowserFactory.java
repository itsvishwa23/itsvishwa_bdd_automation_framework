package utilities;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ThreadGuard;

import java.util.Properties;

public class BrowserFactory {
    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private Logger log;
    private Properties prop;
    private String browserName;

    public WebDriver browserSetup() {
        try {
            log = LogManager.getLogger(this.getClass().getName());
            prop = new Properties();
            prop.load(BrowserFactory.class.getClassLoader().getResourceAsStream("configuration.properties"));
            browserName = prop.getProperty("browser");

            log.info("Browser is " + browserName);

            if (browserName.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                driver.set(ThreadGuard.protect(new ChromeDriver(options)));
            } else if (browserName.equalsIgnoreCase("edge")) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("headless");
                driver.set(ThreadGuard.protect(new EdgeDriver(options)));
            } else if (browserName.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("-headless");
                driver.set(ThreadGuard.protect(new FirefoxDriver(options)));
            } else {
                log.info("unsupported browser is passed: " + browserName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getDriverInstance();
    }

    public static synchronized WebDriver getDriverInstance() {
        return driver.get();
    }
}
