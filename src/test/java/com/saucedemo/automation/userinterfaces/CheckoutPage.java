package com.saucedemo.automation.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {
    //Form Inputs
    public static final Target FIRST_NAME = Target.the("first name field")
            .locatedBy("#first-name");
    public static final Target LAST_NAME = Target.the("last name field")
            .locatedBy("#last-name");
    public static final Target POSTAL_CODE = Target.the("postal code field")
            .locatedBy("#postal-code");

    //Buttons
    public static final Target BTN_CONTINUE = Target.the("continue button")
            .locatedBy("#continue");

    public static final Target BTN_FINISH = Target.the("finish button")
            .located(By.id("finish"));

    //Summary Labels
    public static final Target PAYMENT_INFO = Target.the("payment information label")
            .locatedBy("[data-test='payment-info-value']");
    public static final Target SHIPPING_INFO = Target.the("shipping information label")
            .locatedBy("[data-test='shipping-info-value']");
    public static final Target TOTAL_LABEL = Target.the("total price label")
            .locatedBy("[data-test='total-label']");

    //Titles and Headers
    public static final Target SUMMARY_TITLE = Target.the("checkout overview title")
            .locatedBy("[data-test='title']");
    public static final Target LBL_SUCCESS_HEADER = Target.the("order success header")
            .locatedBy(".complete-header");
}