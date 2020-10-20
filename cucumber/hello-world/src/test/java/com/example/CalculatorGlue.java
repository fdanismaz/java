package com.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class CalculatorGlue {
    private int x;
    private int y;
    private int answer;

    @Given("X is {int}")
    public void xIs(int value) {
        x = value;
    }

    @And("Y is {int}")
    public void yIs(int value) {
        y = value;
    }

    @When("I ask their sum")
    public void iAskTheirSum() {
        answer = x + y;
    }

    @Then("I should be told as {int}")
    public void iShouldBeToldAss(int expectedAnswer) {
        assertEquals(expectedAnswer, answer);
    }
}
