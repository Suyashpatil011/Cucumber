Feature: Search and Place the Product and Place the Order

  Scenario: User is able to Search the Product from both home and offer Page
    Given  User is on Greencard Landing Page
    When User search the with shortname with "Tom" and extracted actual name of Product
    Then User search the same shortname "Tom" in offer page
    And Validated product name in offerpage is maches with landingpage


