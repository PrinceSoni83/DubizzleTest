package dubizzle.StepDefinitions;

import dubizzle.Helpers.WaitHelper;
import dubizzle.Helpers.WebElementHelper;
import dubizzle.PageDefinitions.DubizzlePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class dubizzleSteps {
    DubizzlePage dubizzlePage = new DubizzlePage();


    @Given("^Customer opens the url \"([^\"]*)\"$")
    public void customerOpensTheURL(String url) throws Throwable {
        dubizzlePage.getURL(url);
        WebElement elm = dubizzlePage.getElement("propertiesForRent");
        WaitHelper.waitUntilVisible(10,elm);
        Assert.assertTrue("Dubizzle Home page is not displayed",dubizzlePage.isHomePageDisplayed());
    }

    @When("^Customer mouse hover to Property For Rent$")
    public void customerMouseHoverToPropertyForRent() throws Throwable {
        WebElement element = dubizzlePage.getElement("propertiesForRent");
        WebElementHelper.mouseHoverToElement(element);
    }

    @And("^Clicks on Apartment Flat for rent link$")
    public void clicksOnApartmentFlatForRentLink() throws Throwable {
        WebElementHelper.clickElement(dubizzlePage.getElement("flatForRent"));
    }

    @Then("^Customer can see the Apartments Real Estate and Property for rent in Dubai screen$")
    public void customerCanSeeTheApartmentsRealEstateAndPropertyForRentInDubaiScreen() throws Throwable {
        WebElement elm = dubizzlePage.getElement("priceFilter");
        WaitHelper.waitUntilVisible(10,elm);
        Assert.assertTrue("Price range filter is not displayed on the screen",dubizzlePage.isPriceFilterDisplayed());
        WebElementHelper.clickElement(dubizzlePage.getElement("priceFilter"));
    }

    @When("^Filter listings by Price between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void filterListingsByPriceBetweenAnd(String minPrice, String maxPrice) throws Throwable {
        WebElement elm = dubizzlePage.getElement("minPrice");
        WaitHelper.waitUntilVisible(10,elm);
        dubizzlePage.enterMinPrice(minPrice);
        dubizzlePage.enterMaxPrice(maxPrice);
        WebElementHelper.clickElement(dubizzlePage.getElement("priceFilterShow"));
    }

    @And("^Click on Search button$")
    public void clickOnSearchButton() throws Throwable {
          dubizzlePage.clickOnSearchButton();
    }

    @Then("^Validate that the first \"([^\"]*)\" page result has price between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void validateTheFirstPageResultHasPriceBetween(String page, String minPrice, String maxPrice) throws Throwable {
        Boolean bFlag = false;
        WebElement elm = dubizzlePage.getElement("priceList");
        WaitHelper.waitUntilVisible(10,elm);
        //Validate that the no of pages are equal to or greater than the expected search pages
        Assert.assertTrue("No. of pages are lesser than the expected pages for search",dubizzlePage.validateNumberOfPages(page));
        // validate that the Price is not withing specified rang
        bFlag = dubizzlePage.isPriceResultsAreBetweenSpecificRange(minPrice,maxPrice);
        Assert.assertTrue("Price is not withing specified range",bFlag);
      }
}
