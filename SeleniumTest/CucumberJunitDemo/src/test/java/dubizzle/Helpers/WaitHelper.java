package dubizzle.Helpers;

import dubizzle.PageDefinitions.BasePage;
import dubizzle.PageDefinitions.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper extends BasePage {

    public static void waitUntilVisible(int i, WebElement locator) throws Exception{
        WebDriver driver = PageFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver,i);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static void waitUntilClickable(int i, WebElement locator) throws Exception{
        WebDriver driver = PageFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver,i);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
