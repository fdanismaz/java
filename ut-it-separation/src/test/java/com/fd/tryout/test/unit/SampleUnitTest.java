package com.fd.tryout.test.unit;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author furkand
 * 10/16/2018 11:43 AM
 */
public class SampleUnitTest {

    @Test
    public void testSampleUnit() {
        System.out.println("Sample unit test");
        assertThat(true, is(true));
    }
}
