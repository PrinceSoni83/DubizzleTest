package dubizzle.PageDefinitions;

import cucumber.api.java.en_lol.WEN;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private static WebDriver driver;

    public static WebDriver getDriver () {
        return driver;
    }

    public static void setDriver(WebDriver driverInstance){
        driver = driverInstance;
    }
}
