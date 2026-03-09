package com.saucedemo.automation.tasks;

import com.saucedemo.automation.userinterfaces.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    private final String username;
    private final String password;

    //Constructor used by instrumented()
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Successful login
    public static Performable asStandardUser(EnvironmentVariables vars) {
        String user = EnvironmentSpecificConfiguration.from(vars).getProperty("credentials.standard.user");
        String pass = EnvironmentSpecificConfiguration.from(vars).getProperty("credentials.standard.password");
        return instrumented(Login.class, user, pass);
    }

    //Failed login
    public static Performable withInvalidCredentials(EnvironmentVariables vars) {
        String user = EnvironmentSpecificConfiguration.from(vars).getProperty("credentials.invalid.user");
        String pass = EnvironmentSpecificConfiguration.from(vars).getProperty("credentials.invalid.password");
        return instrumented(Login.class, user, pass);
    }

    @Override
    @Step("{0} attempts to login")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.USERNAME_FIELD),
                Enter.theValue(password).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}