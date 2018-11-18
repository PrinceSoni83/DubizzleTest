$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/dubizzle.feature");
formatter.feature({
  "line": 1,
  "name": "validate the property listing screen by price filter",
  "description": "",
  "id": "validate-the-property-listing-screen-by-price-filter",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 5,
  "name": "User should be able to filter Property Listing by Price",
  "description": "",
  "id": "validate-the-property-listing-screen-by-price-filter;user-should-be-able-to-filter-property-listing-by-price",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@Dubizzle_TC_01"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Customer opens the url \"\u003cURL\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Customer mouse hover to Property For Rent",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Clicks on Apartment Flat for rent link",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Customer can see the Apartments Real Estate and Property for rent in Dubai screen",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Filter listings by Price between \"\u003cMIN Price\u003e\" and \"\u003cMAX Price\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Click on Search button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Validate that the first \"\u003cNo of Page\u003e\" page result has price between \"\u003cMIN Price\u003e\" and \"\u003cMAX Price\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "validate-the-property-listing-screen-by-price-filter;user-should-be-able-to-filter-property-listing-by-price;",
  "rows": [
    {
      "cells": [
        "URL",
        "MIN Price",
        "MAX Price",
        "No of Page"
      ],
      "line": 14,
      "id": "validate-the-property-listing-screen-by-price-filter;user-should-be-able-to-filter-property-listing-by-price;;1"
    },
    {
      "cells": [
        "https://dubai.dubizzle.com",
        "60000",
        "80000",
        "2"
      ],
      "line": 15,
      "id": "validate-the-property-listing-screen-by-price-filter;user-should-be-able-to-filter-property-listing-by-price;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1638984594,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "User should be able to filter Property Listing by Price",
  "description": "",
  "id": "validate-the-property-listing-screen-by-price-filter;user-should-be-able-to-filter-property-listing-by-price;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@Dubizzle_TC_01"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Customer opens the url \"https://dubai.dubizzle.com\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Customer mouse hover to Property For Rent",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Clicks on Apartment Flat for rent link",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Customer can see the Apartments Real Estate and Property for rent in Dubai screen",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Filter listings by Price between \"60000\" and \"80000\"",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Click on Search button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Validate that the first \"2\" page result has price between \"60000\" and \"80000\"",
  "matchedColumns": [
    1,
    2,
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://dubai.dubizzle.com",
      "offset": 24
    }
  ],
  "location": "dubizzleSteps.customerOpensTheURL(String)"
});
formatter.result({
  "duration": 6434180467,
  "status": "passed"
});
formatter.match({
  "location": "dubizzleSteps.customerMouseHoverToPropertyForRent()"
});
formatter.result({
  "duration": 38690437,
  "status": "passed"
});
formatter.match({
  "location": "dubizzleSteps.clicksOnApartmentFlatForRentLink()"
});
formatter.result({
  "duration": 3155462486,
  "status": "passed"
});
formatter.match({
  "location": "dubizzleSteps.customerCanSeeTheApartmentsRealEstateAndPropertyForRentInDubaiScreen()"
});
formatter.result({
  "duration": 155128658,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "60000",
      "offset": 34
    },
    {
      "val": "80000",
      "offset": 46
    }
  ],
  "location": "dubizzleSteps.filterListingsByPriceBetweenAnd(String,String)"
});
formatter.result({
  "duration": 473933232,
  "status": "passed"
});
formatter.match({
  "location": "dubizzleSteps.clickOnSearchButton()"
});
formatter.result({
  "duration": 80542017,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 25
    },
    {
      "val": "60000",
      "offset": 59
    },
    {
      "val": "80000",
      "offset": 71
    }
  ],
  "location": "dubizzleSteps.validateTheFirstPageResultHasPriceBetween(String,String,String)"
});
formatter.result({
  "duration": 2351298285,
  "status": "passed"
});
formatter.after({
  "duration": 102654302,
  "status": "passed"
});
});