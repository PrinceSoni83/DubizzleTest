package dubizzle.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import dubizzle.PageDefinitions.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BrowserManagement {
    public static WebDriver driver;
    @Before(order = 1)
    public void prepareBrowser() throws Exception {
        String home = System.getProperty("user.home");
        driver = getWebDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @After(order = 100)
    public void closeBrowser() throws Exception {
        driver.quit();
    }

    public WebDriver getWebDriver () throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/princesoni/CucumberJunitDemo/src/test/resources/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-infobars");
        /* Maximize the browser for windows machine */
        //options.addArguments("--start-maximized");
        /* Maximize the browser for iOS machine */
        options.addArguments("--kiosk");
        ChromeDriver driver = new ChromeDriver(options);
        PageFactory.setDriver(driver);
        return driver;
    }
}
