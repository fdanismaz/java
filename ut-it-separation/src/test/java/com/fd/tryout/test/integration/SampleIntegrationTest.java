package com.fd.tryout.test.integration;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author furkand
 * 10/16/2018 11:43 AM
 */
public class SampleIntegrationTest {

    @Test
    public void testSampleUnit() {
        System.out.println("Sample integration test");
        assertThat(true, is(true));
    }
}
