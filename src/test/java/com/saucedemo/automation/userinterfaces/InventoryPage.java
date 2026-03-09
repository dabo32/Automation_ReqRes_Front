package com.saucedemo.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage {
    public static final Target TITLE_SPAN = Target.the("inventory title")
            .located(By.xpath("//span[@class='title']"));

    public static final Target BTN_PRODUCTO = Target.the("add to cart button for {0}")
            .locatedBy("//div[@class='inventory_item_description' and .//div[text()='{0}']]//button");

    public static final Target PRODUCT_NAME_IN_CART = Target.the("product name in cart {0}")
            .locatedBy("//div[@class='cart_item']//div[@class='inventory_item_name' and text()='{0}']");

    public static final Target CART_ICON = Target.the("shopping cart icon")
            .located(By.className("shopping_cart_link"));

    public static final Target CART_BADGE = Target.the("shopping_cart_badge")
            .located(By.className("shopping_cart_badge"));
}