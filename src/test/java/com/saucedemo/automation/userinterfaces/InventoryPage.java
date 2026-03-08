package com.saucedemo.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {
    //Validate successful login
    public static final Target TITLE_SPAN = Target.the("inventory title")
            .located(By.xpath("//span[@class='title']"));

    //Button to add a specific product
    public static final Target ADD_TO_CART_BACKPACK = Target.the("add backpack to cart button")
            .located(By.id("add-to-cart-sauce-labs-backpack"));

    //Shopping cart icon
    public static final Target CART_BADGE = Target.the("shopping cart badge")
            .located(By.className("shopping_cart_badge"));
}