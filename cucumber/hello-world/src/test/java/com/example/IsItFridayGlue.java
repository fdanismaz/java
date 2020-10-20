package com.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class IsItFridayGlue {
    private String today;
    private String answer;

    @Given("today is {string}")
    public void todayIs(String day) {
        today = day;
    }

    @When("I ask whether it's Friday yet")
    public void iAskWhetherItSFridayYet() {
        answer = IsFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void iShouldBeTold(String expectedAnswer) {
        assertEquals(expectedAnswer, answer);
    }
}
