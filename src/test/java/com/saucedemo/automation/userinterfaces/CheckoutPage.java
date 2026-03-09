package com.saucedemo.automation.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {
    public static final Target FIRST_NAME = Target.the("first name input").
            locatedBy("#first-name");
    public static final Target LAST_NAME = Target.the("last name input")
            .locatedBy("#last-name");
    public static final Target POSTAL_CODE = Target.the("postal code input")
            .locatedBy("#postal-code");
    //
    public static final Target BTN_CONTINUE = Target.the("continue button")
            .locatedBy("#continue");
    public static final Target BTN_FINISH = Target.the("botón Finish")
            .located(By.id("finish"));
    public static final Target PAYMENT_INFO = Target.the("payment info")
            .locatedBy("[data-test='payment-info-value']");
    public static final Target SHIPPING_INFO = Target.the("shipping info")
            .locatedBy("[data-test='shipping-info-value']");
    public static final Target TOTAL_LABEL = Target.the("precio total")
            .locatedBy("[data-test='total-label']");
    //
    public static final Target LBL_SUCCESS_HEADER = Target.the("success header")
            .locatedBy(".complete-header");
    public static final Target SUMMARY_TITLE = Target.the("checkout overview title")
            .locatedBy("[data-test='title']");
}