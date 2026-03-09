@SauceDemo
Feature: SauceDemo Shopping Workflow
  As a web store user
  I want to perform authentication and product management operations
  To ensure the purchase process is stable and functional

  Background:
    Given the actor is on the login page

  @SuccessfulLogin
  Scenario: Successful login with a valid user
    When the actor enters valid credentials
    Then they should be redirected to the product catalog

  @FailedLogin
  Scenario: Failed login with an invalid user
    When the actor attempts to login with incorrect credentials
    Then they should see an informative error message

  @AddProduct
  Scenario: Add a single product to the cart
    When the actor adds the "Sauce Labs Backpack" to the cart
    Then the cart icon should display "1" added product
    And the product name in the cart should be valid

  @CompletePurchase
  Scenario: Complete a purchase with one product in the cart
    Given the actor has added a product to the cart
    When they complete the checkout process with their personal details
    Then they should see the summary with payment and total price
    And they confirm the purchase to see the message "Thank you for your order!"

  @MultipleProductsWorkflow
  Scenario: Manage multiple products, remove one, and complete purchase
    When the actor adds the following products to the cart:
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
    And they remove "Sauce Labs Bike Light" from the cart
    And they finish the checkout process
    Then the order should be processed successfully