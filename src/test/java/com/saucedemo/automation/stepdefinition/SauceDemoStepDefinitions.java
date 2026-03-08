package com.saucedemo.automation.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;

import java.util.List;

public class SauceDemoStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the actor is on the login page")
    public void theActorIsOnTheLoginPage() {
        OnStage.theActorCalled("David").attemptsTo(
                Open.browserOn().thePageNamed("pages.saucedemo")
        );
    }

    @When("the actor enters valid credentials")
    public void theActorEntersValidCredentials() {
        // Here we will call the Login Task
    }

    @Then("they should be redirected to the product catalog")
    public void theyShouldBeRedirectedToTheProductCatalog() {
        // Here we will use a Question to verify the Inventory page
    }

    @When("the actor attempts to login with incorrect credentials")
    public void theActorAttemptsToLoginWithIncorrectCredentials() {
        // Task for failed login
    }

    @Then("they should see an informative error message")
    public void theyShouldSeeAnInformativeErrorMessage() {
        // Question for error message
    }

    @When("the actor adds the {string} to the cart")
    public void theActorAddsTheToTheCart(String productName) {
        // Task to add a specific product
    }

    @Then("the cart icon should display {string} added product")
    public void theCartIconShouldDisplayAddedProduct(String count) {
        // Question for cart count
    }

    @Given("the actor has added a product to the cart")
    public void theActorHasAddedAProductToTheCart() {
        // Pre-condition task
    }

    @When("they complete the checkout process with their personal details")
    public void theyCompleteTheCheckoutProcessWithTheirPersonalDetails() {
        // Task for checkout flow
    }

    @Then("they should see the confirmation message {string}")
    public void theyShouldSeeTheConfirmationMessage(String expectedMessage) {
        // Question for success message
    }

    @When("the actor adds the following products to the cart:")
    public void theActorAddsTheFollowingProductsToTheCart(List<String> products) {
        // Task using the Data Table list
    }

    @When("they remove {string} from the cart")
    public void theyRemoveFromTheCart(String productName) {
        // Task to remove item
    }

    @When("they finish the checkout process")
    public void theyFinishTheCheckoutProcess() {
        // Task to finalize
    }

    @Then("the order should be processed successfully")
    public void theOrderShouldBeProcessedSuccessfully() {
        // Final validation
    }
}