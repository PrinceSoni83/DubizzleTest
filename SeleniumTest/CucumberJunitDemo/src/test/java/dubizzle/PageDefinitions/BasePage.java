package dubizzle.PageDefinitions;

import dubizzle.Helpers.WaitHelper;
import gherkin.lexer.Pa;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BasePage {
    private static final String BASE_PATH = System.getProperty("user.dir")+"/src/test/java/";
    private static final int WEBELEMENT_DEFAULT_TIMEOUT = 15;
    public static WebDriver driver;
    private Properties properties;


    public BasePage() {
        this.driver = PageFactory.getDriver();
        try {
            String filename = this.getClass().getName().replaceAll("\\.","/") + ".properties";
            properties = new Properties();
            FileInputStream input  = new FileInputStream(BASE_PATH + filename);
            properties.load(input);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebElement getElement(String name) throws Exception {
        String[] property = getElementProperty(name);
        WebElement element;
        try {
            element = getWebElement(property[0], property[1], true);
            if (element == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception("Element is not found in the page"+name);
        }
        return element;
    }

    public WebElement getWebElement(String elementName, String type, boolean wait) throws Exception {
        WebElement element = null;
        int seconds = WEBELEMENT_DEFAULT_TIMEOUT;
        long time = 1000 * seconds;
        type = type.trim();
        boolean timeout = false;
        while (!timeout && time > 0) {
            try {
                if (type.equalsIgnoreCase("id")) {
                    element = driver.findElement(By.id(elementName));
                } else if (type.equalsIgnoreCase("css")) {
                    element = driver.findElement(By.cssSelector(elementName));
                } else if (type.equalsIgnoreCase("class")) {
                    element = driver.findElement(By.className(elementName));
                } else if (type.equalsIgnoreCase("partialLink")) {
                    element = driver.findElement(By.partialLinkText(elementName));
                } else if (type.equalsIgnoreCase("xpath")) {
                    element = driver.findElement(By.xpath(elementName));
                } else if (type.equalsIgnoreCase("name")) {
                    element = driver.findElement(By.name(elementName));
                } else if (type.equalsIgnoreCase("tagname")) {
                    element = driver.findElement(By.tagName(elementName));
                } else {
                    throw new Exception(String.format("Element type %s is not supported at the moment", type));
                }
                timeout = true;
            } catch (Exception e) {
                if(wait) {
                    timeout = false;
                    Thread.sleep(100);
                    time = time - 100;
                }else{
                    timeout = true;
                }
            }
        }
        if (!timeout) {
            throw new Exception("Element not clickable at the moment");
        }
        return element;
    }

    public List<WebElement> getElements(String name) throws Exception {
        String elementName = getProperty(name);
        String type = getProperty(name + "Type");
        List<WebElement> elementList = new ArrayList<WebElement>();
        try {
            elementList = getWebElements(elementName, type);
            if (elementList.size() == 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(String.format(
                    "Element %s is not found in the page", name));
        }
        return elementList;
    }

    public List<WebElement> getWebElements(String locator, String type)
            throws Exception {
        int seconds = WEBELEMENT_DEFAULT_TIMEOUT;
        long time = 1000 * seconds;
        boolean timeout = false;
        List<WebElement> elementList = new ArrayList<WebElement>();
        while (!timeout && time > 0) {
            try {
                if (type.equalsIgnoreCase("id")) {
                    elementList = driver.findElements(By.id(locator));
                } else if (type.equalsIgnoreCase("css")) {
                    elementList = driver.findElements(By.cssSelector(locator));
                } else if (type.equalsIgnoreCase("class")) {
                    elementList = driver.findElements(By.className(locator));
                } else if (type.equalsIgnoreCase("partialLink")) {
                    elementList = driver.findElements(By
                            .partialLinkText(locator));
                } else if (type.equalsIgnoreCase("xpath")) {
                    elementList = driver.findElements(By.xpath(locator));
                } else if (type.equalsIgnoreCase("name")) {
                    elementList = driver.findElements(By.name(locator));
                } else if (type.equalsIgnoreCase("tagname")) {
                    elementList = driver.findElements(By.tagName(locator));
                } else {
                    throw new Exception(String.format(
                            "Element type %s is not supported at the moment",
                            type));
                }
                timeout = true;
            } catch (Exception e) {
                timeout = false;
                Thread.sleep(100);
                time = time - 100;
            }
        }
        if (!timeout) {
            throw new Exception(String.format(
                    "Element %s could not be found in the page", locator));
        }
        return elementList;

    }

    public String[] getElementProperty(String name) throws Exception {
        String element[] = new String[2];
        element[0] = getProperty(name);
        element[1] = getProperty(name + "Type");
        if (element[0] != null && element[1] == null) {
            throw new Exception("Element type cannot be null in property file");
        }

        return element;
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }

    public static void mouseHoverToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
}
