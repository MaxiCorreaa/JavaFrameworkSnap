package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverHelper {


    private static WebDriver driver;
    private static final ReadConfigFile STRATEGY = new ReadConfigFile();

    private DriverHelper() {

    }

    public static WebDriver getDriverInstance() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private static WebDriver createDriver() {
        if (STRATEGY.getBrowser().equalsIgnoreCase("Chrome")) {
            return createChromeDriver();
        } else if (STRATEGY.getBrowser().equalsIgnoreCase("Firefox")) {
            return createFirefoxDriver();
        } else {
            throw new IllegalArgumentException("Browser not set");
        }
    }

    public static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, STRATEGY.getPageLoadTimeout());
    }

    private static WebDriver createChromeDriver() {
        driver = WebDriverManager.chromedriver().capabilities(CapabilitiesBrowser.getChromeOptions()).create();
        driver.manage().window().maximize();
        driver.get(STRATEGY.getUrl());
        driver.manage().timeouts().implicitlyWait(STRATEGY.getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        driver = WebDriverManager.firefoxdriver().capabilities(CapabilitiesBrowser.getFirefoxOptions()).create();
        driver.manage().window().maximize();
        driver.get(STRATEGY.getUrl());
        driver.manage().timeouts().implicitlyWait(STRATEGY.getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver closeDriver() {
        driver.quit();
        return null;
    }

}
