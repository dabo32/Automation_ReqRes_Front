package com.saucedemo.automation.questions;

import com.saucedemo.automation.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CheckoutQuestions {

    public static Question<String> successMessage() {
        return Question.about("thank you header")
                .answeredBy(actor -> Text.of(CheckoutPage.LBL_SUCCESS_HEADER).answeredBy(actor));
    }

    public static Question<String> paymentInfo() {
        return Question.about("payment information")
                .answeredBy(actor -> Text.of(CheckoutPage.PAYMENT_INFO).answeredBy(actor));
    }

    public static Question<String> shippingInfo() {
        return Question.about("shipping information")
                .answeredBy(actor -> Text.of(CheckoutPage.SHIPPING_INFO).answeredBy(actor));
    }

    public static Question<String> totalPrice() {
        return Question.about("Total price")
                .answeredBy(actor -> Text.of(CheckoutPage.TOTAL_LABEL).answeredBy(actor));
    }
}