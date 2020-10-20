package com.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/is_it_friday_yet.feature",
        glue = {"com.example"}
)
public class IsItFridayTest {
}
