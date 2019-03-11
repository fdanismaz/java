package com.fd.jackson.inheritance;

import lombok.Getter;
import lombok.Setter;

/**
 * @author fdanismaz
 * date: 3/11/19 8:29 PM
 */
@Getter
@Setter
public class RestApiResponseBody<T> {

	private T body;
}
