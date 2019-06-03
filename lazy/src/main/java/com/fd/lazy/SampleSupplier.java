package com.fd.lazy;

/**
 * @author fdanismaz
 * date: 6/3/19 3:48 PM
 */
public class SampleSupplier {

	public static int CALL_TRACKER = 0;

	public String getMessage() {
		return "Hello World. This method is called " + ++CALL_TRACKER + " times";
	}

	public String getMessage(int i) {
		return "Hello World. Passed value is : " + i;
	}
}
