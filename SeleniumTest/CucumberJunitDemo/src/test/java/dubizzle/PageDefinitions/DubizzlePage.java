package dubizzle.PageDefinitions;

import dubizzle.Helpers.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DubizzlePage extends BasePage{

    public void getURL(String url) {
        driver.get(url);
    }

    public boolean isHomePageDisplayed() throws Exception {
        try {
            if  (WebElementHelper.isElementDisplayed(getElement("propertiesForRent"))) {
                return true;
            }   else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("Home page is not displayed"+ e.getMessage());
        }
    }

    public boolean isPriceFilterDisplayed() throws Exception {
        try {
            if  (WebElementHelper.isElementDisplayed(getElement("priceFilter"))) {
                return true;
            }   else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception("Price filter is not displayed"+ e.getMessage());
        }
    }

    public void clickOnSearchButton() throws Exception {
        try {
            WebElementHelper.clickElement(getElement("searchButton"));
        } catch (Exception e) {
            throw new Exception("Search button is not clickable" + e.getMessage());
        }
    }

    public void enterMinPrice(String minPrice) throws Exception {
        WebElementHelper.enterText(getElement("minPrice"),minPrice);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    public void enterMaxPrice(String maxPrice) throws Exception {
        WebElementHelper.enterText(getElement("maxPrice"),maxPrice);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    }

    public boolean validateNumberOfPages(String page) throws Exception {
        Boolean bFlag = false;
            List<WebElement> noOfPages = getElements("noOfPages");
            int pages = noOfPages.size();
            if (pages >= Integer.parseInt(page)) {
                bFlag = true;
            }
        return bFlag;
    }

    public boolean isPriceResultsAreBetweenSpecificRange(String minPrice, String maxPrice) throws Exception {
        //get the list of price in a page
        Boolean bFlag = true;
        String price;
        List<WebElement> allPriceElement = getElements("listOfPriceElements");
        for (WebElement elm : allPriceElement) {
            price = elm.getText();
            price = price.replace("AED ", "").replace(",","");
            if (!(Long.parseLong(price) >= 60000) && (Long.parseLong(price) <= 80000) ) {
                System.out.println(price);
                bFlag = false;
                break;
            }
        }
        return bFlag;
    }
}
