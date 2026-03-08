package com.saucedemo.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USERNAME_FIELD = Target.the("username input")
            .located(By.id("user-name"));
    public static final Target PASSWORD_FIELD = Target.the("password input")
            .located(By.id("password"));
    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.id("login-button"));
}