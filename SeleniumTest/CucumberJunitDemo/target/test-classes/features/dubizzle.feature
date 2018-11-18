Feature: validate the property listing screen by price filter


  @Dubizzle_TC_01
  Scenario Outline: User should be able to filter Property Listing by Price
    Given Customer opens the url "<URL>"
    When Customer mouse hover to Property For Rent
    And Clicks on Apartment Flat for rent link
    Then Customer can see the Apartments Real Estate and Property for rent in Dubai screen
    When Filter listings by Price between "<MIN Price>" and "<MAX Price>"
    And Click on Search button
    Then Validate that the first "<No of Page>" page result has price between "<MIN Price>" and "<MAX Price>"
    Examples:
      | URL                         | MIN Price | MAX Price | No of Page |
      | https://dubai.dubizzle.com  | 60000     | 80000     |     2      |