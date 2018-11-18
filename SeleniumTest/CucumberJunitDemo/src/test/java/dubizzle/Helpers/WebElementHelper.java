package dubizzle.Helpers;

import dubizzle.PageDefinitions.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class WebElementHelper extends BasePage {



    public static boolean isElementDisplayed (WebElement element) throws Exception {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void clickElement(WebElement searchButton) throws Exception {
        try {
            searchButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void enterText(WebElement element , String text) {
        element.click();
        element.sendKeys(text);
        element.sendKeys(Keys.TAB);
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
    }
}
