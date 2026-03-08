package com.saucedemo.automation.stepdefinitions;

import com.saucedemo.automation.questions.TheInventoryTitle;
import com.saucedemo.automation.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.util.EnvironmentVariables;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SauceDemoStepDefinitions {

    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the actor is on the login page")
    public void theActorIsOnTheLoginPage() {
        OnStage.theActorCalled("David"); //Main actor
        OnStage.theActorInTheSpotlight().wasAbleTo(
                Open.browserOn().thePageNamed("pages.saucedemo")
        );
    }

    @When("the actor enters valid credentials")
    public void theActorEntersValidCredentials() {
        String user = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("credentials.standard.user");
        String password = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("credentials.standard.password");

        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(user, password)
        );
    }

    @Then("they should be redirected to the product catalog")
    public void theyShouldBeRedirectedToTheProductCatalog() {
        //Question to validate title 'Products'
        OnStage.theActorInTheSpotlight().should(
                seeThat("the inventory title", TheInventoryTitle.value(), equalTo("Products"))
        );
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