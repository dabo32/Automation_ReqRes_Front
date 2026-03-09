package com.saucedemo.automation.questions;

import com.saucedemo.automation.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheErrorMessageQuestions implements Question<String> {
    public static TheErrorMessageQuestions value() {
        return new TheErrorMessageQuestions();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.ERROR_MESSAGE).answeredBy(actor);
    }
}