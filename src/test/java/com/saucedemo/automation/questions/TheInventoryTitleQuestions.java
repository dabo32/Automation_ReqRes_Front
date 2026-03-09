package com.saucedemo.automation.questions;

import com.saucedemo.automation.userinterfaces.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheInventoryTitleQuestions implements Question<String> {

    public static TheInventoryTitleQuestions value() {
        return new TheInventoryTitleQuestions();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(InventoryPage.TITLE_SPAN).answeredBy(actor);
    }
}