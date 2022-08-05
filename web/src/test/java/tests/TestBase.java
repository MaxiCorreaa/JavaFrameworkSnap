package tests;

import commons.DriverHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        driver = DriverHelper.getDriverInstance();
        wait = DriverHelper.getWebDriverWait();
    }

    @AfterAll
    public static void teardown() {
        driver = DriverHelper.closeDriver();
    }
}
