package com.saucedemo.automation.questions;

import com.saucedemo.automation.userinterfaces.InventoryPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CartQuestions {

    //Static badge
    public static Question<String> currentlyDisplayed() {
        return Question.about("the number of items in the cart: ")
                .answeredBy(actor -> {
                    if (!InventoryPage.CART_BADGE.resolveFor(actor).isPresent()) {
                        return "0";
                    }
                    return Text.of(InventoryPage.CART_BADGE).answeredBy(actor);
                });
    }

    //Validate dinamic products
    public static Question<String> productNameDisplayed(String productName) {
        return Question.about("Product name: ")
                .answeredBy(actor -> Text.of(InventoryPage.PRODUCT_NAME_IN_CART.of(productName))
                        .answeredBy(actor));
    }
}