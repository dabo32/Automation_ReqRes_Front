package com.saucedemo.automation.stepdefinitions;

import com.saucedemo.automation.questions.CartQuestions;
import com.saucedemo.automation.questions.CheckoutQuestions;
import com.saucedemo.automation.questions.TheErrorMessageQuestions;
import com.saucedemo.automation.questions.TheInventoryTitleQuestions;
import com.saucedemo.automation.tasks.AddToCart;
import com.saucedemo.automation.tasks.CompletePurchase;
import com.saucedemo.automation.tasks.Login;
import com.saucedemo.automation.userinterfaces.CheckoutPage;
import com.saucedemo.automation.userinterfaces.InventoryPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.model.util.EnvironmentVariables;

import java.util.List;

import static com.saucedemo.automation.userinterfaces.CheckoutPage.BTN_FINISH;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class SauceDemoStepDefinitions {

    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    //Background: Inital configuration
    @Given("the actor is on the login page")
    public void theActorIsOnTheLoginPage() {
        OnStage.theActorCalled("David"); //Main actor
        theActorInTheSpotlight().wasAbleTo(
                Open.browserOn().thePageNamed("pages.saucedemo")
        );
    }

    //Escenario: @SuccessfulLogin
    @When("the actor enters valid credentials")
    public void theActorEntersValidCredentials() {
        //private method to login
        theActorInTheSpotlight().attemptsTo(
                Login.asStandardUser(environmentVariables)
        );
    }

    @Then("they should be redirected to the product catalog")
    public void theyShouldBeRedirectedToTheProductCatalog() {
        //Question to validate title 'Products'
        theActorInTheSpotlight().should(
                seeThat("the inventory title", TheInventoryTitleQuestions.value(), equalTo("Products"))
        );
    }
    //---------

    //Escenario: @FailedLogin
    @When("the actor attempts to login with incorrect credentials")
    public void theActorAttemptsToLoginWithIncorrectCredentials() {
        theActorInTheSpotlight().attemptsTo(
                Login.withInvalidCredentials(environmentVariables)
        );
    }

    @Then("they should see an informative error message")
    public void theyShouldSeeAnInformativeErrorMessage() {
        theActorInTheSpotlight().should(
                seeThat("the error message", TheErrorMessageQuestions.value(),
                        containsString("Epic sadface"))
        );
    }
    //---------

    //Escenario: @AddProduct
    @When("the actor adds the {string} to the cart")
    public void theActorAddsTheToTheCart(String productName) {
        // El actor guarda el nombre en su memoria técnica
        theActorInTheSpotlight().remember("selectedProduct", productName);

        theActorInTheSpotlight().attemptsTo(
                Login.asStandardUser(environmentVariables),
                AddToCart.theProduct(productName)
        );
    }

    @Then("the cart icon should display {string} added product")
    //Validate number's feature
    public void validateCartBadge(String expectedCount) {
        theActorInTheSpotlight().should(
                seeThat("el contador del carrito",
                        CartQuestions.currentlyDisplayed(),
                        equalTo(expectedCount))
        );
    }

    @And("the product name in the cart should be valid")
    public void validateProductName() {
        //The actor remember the product's name
        String productName = theActorInTheSpotlight().recall("selectedProduct");

        //Enter to shopping cart
        theActorInTheSpotlight().attemptsTo(
                Click.on(InventoryPage.CART_ICON),
                WaitUntil.the(InventoryPage.PRODUCT_NAME_IN_CART.of(productName), isVisible())
        );

        //Validate product
        theActorInTheSpotlight().should(
                seeThat("Products in the cart: ",
                        CartQuestions.productNameDisplayed(productName),
                        equalTo(productName))
        );
    }
    //---------


    //Escenario: @CompletePurchase
    @Given("the actor has added a product to the cart")
    public void theActorHasAddedAProductToTheCart() {
        theActorInTheSpotlight().attemptsTo(
                Login.asStandardUser(environmentVariables),
                AddToCart.theProduct("Sauce Labs Backpack"),
                // IMPORTANTE: Navegar al formulario antes del siguiente paso
                Click.on(InventoryPage.CART_ICON),
                Click.on(Target.the("checkout button").locatedBy("#checkout"))
        );
    }

    @When("they complete the checkout process with their personal details")
    public void finishPurchase() {
        theActorInTheSpotlight().attemptsTo(
                CompletePurchase.withDetails("David", "Santiago", "110111")
        );
    }

    @Then("they should see the summary with payment and total price")
    public void validateSummary() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutPage.SUMMARY_TITLE, isVisible()).forNoMoreThan(10).seconds()
        );

        theActorInTheSpotlight().should(
                seeThat("Payment info", CheckoutQuestions.paymentInfo(), containsString("SauceCard")),
                seeThat("Shipping information", CheckoutQuestions.shippingInfo(), containsString("Pony Express")),
                seeThat("Total price", CheckoutQuestions.totalPrice(), containsString("$"))
        );
    }

    @And("they confirm the purchase to see the message {string}")
    public void confirmAndValidate(String expectedMessage) {
        //Validate checkout message
        theActorInTheSpotlight().attemptsTo(
                Scroll.to(BTN_FINISH),
                Click.on(BTN_FINISH)
        );
        //See success message
        theActorInTheSpotlight().should(
                seeThat("Success message",
                        CheckoutQuestions.successMessage(),
                        equalTo(expectedMessage))
        );
    }
    //---------

    //Escenario: @MultipleProductsWorkflow
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

//---------
