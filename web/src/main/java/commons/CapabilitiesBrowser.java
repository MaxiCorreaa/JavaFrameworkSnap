package commons;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CapabilitiesBrowser {

    public static final ReadConfigFile STRATEGY = new ReadConfigFile();

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (STRATEGY.getHeadless().equalsIgnoreCase("Si") &&
                STRATEGY.getPrivado().equalsIgnoreCase("Si")) {
            chromeOptions.addArguments("incognito");
            chromeOptions.addArguments("--window-size=1400,600");
            chromeOptions.addArguments("--headless");
        } else if (STRATEGY.getPrivado().equalsIgnoreCase("Si") &&
                STRATEGY.getHeadless().equalsIgnoreCase("No")) {
            chromeOptions.addArguments("incognito");
            chromeOptions.addArguments("start-maximized");
        } else if (STRATEGY.getPrivado().equalsIgnoreCase("No") &&
                STRATEGY.getHeadless().equalsIgnoreCase("Si")) {
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("--headless");
        } else {
            chromeOptions.addArguments("start-maximized");
        }
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (STRATEGY.getHeadless().equalsIgnoreCase("Si") &&
                STRATEGY.getPrivado().equalsIgnoreCase("Si")) {
            firefoxOptions.addArguments("-private");
            firefoxOptions.addArguments("-headless");
        } else if (STRATEGY.getHeadless().equalsIgnoreCase("Si") &&
                STRATEGY.getPrivado().equalsIgnoreCase("No")) {
            firefoxOptions.addArguments("-headless");
        } else if (STRATEGY.getHeadless().equalsIgnoreCase("No") &&
                STRATEGY.getPrivado().equalsIgnoreCase("Si")) {
            firefoxOptions.addArguments("-fullscreen");
            firefoxOptions.addArguments("-private");
        } else {
            firefoxOptions.addArguments("-fullscreen");
        }
        return firefoxOptions;
    }
}
