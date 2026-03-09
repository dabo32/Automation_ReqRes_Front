package com.saucedemo.automation.tasks;

import com.saucedemo.automation.userinterfaces.InventoryPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AddToCart implements Task {

    private final String productName;

    public AddToCart(String productName) {
        this.productName = productName;
    }

    public static AddToCart theProduct(String productName) {
        return instrumented(AddToCart.class, productName);
    }

    @Override
    @Step("{0} adds the product '#productName' to the cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(InventoryPage.BTN_PRODUCTO.of(productName), isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(InventoryPage.BTN_PRODUCTO.of(productName))
        );
    }
}