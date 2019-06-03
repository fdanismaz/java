package com.fd.lazy;

import cyclops.function.Memoize;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.function.Supplier;

/**
 * @author fdanismaz
 * date: 6/3/19 3:49 PM
 */
public class TestSampleSupplier {

	SampleSupplier sampleSupplier = new SampleSupplier();

	Supplier<String> message = Memoize.memoizeSupplier(sampleSupplier::getMessage);

	FunctionPointer<String> message2 = sampleSupplier::getMessage;

	@Test
	public void testSupplier() {
		System.out.println(message.get());
		System.out.println(message.get());
		System.out.println(message.get());
		System.out.println(message.get());
		System.out.println(message.get());
		System.out.println(message.get());
		System.out.println(message.get());
		Assert.assertEquals(SampleSupplier.CALL_TRACKER, 1);
	}

	@Test
	public void test() {
		System.out.println(message2.get(6));
	}
}
