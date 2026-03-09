package com.saucedemo.automation.tasks;

import com.saucedemo.automation.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class CompletePurchase implements Task {

    private final String firstName;
    private final String lastName;
    private final String zip;

    public CompletePurchase(String firstName, String lastName, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zip = zip;
    }

    public static CompletePurchase withDetails(String fName, String lName, String zip) {
        return Tasks.instrumented(CompletePurchase.class, fName, lName, zip);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //Send data to form
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME),
                Enter.theValue(zip).into(CheckoutPage.POSTAL_CODE),

                Click.on(CheckoutPage.BTN_CONTINUE)
        );
    }
}