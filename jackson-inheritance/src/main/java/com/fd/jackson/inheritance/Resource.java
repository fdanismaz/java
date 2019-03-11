package com.fd.jackson.inheritance;

import lombok.Getter;
import lombok.Setter;

/**
 * @author fdanismaz
 * date: 3/11/19 8:30 PM
 */
@Getter
@Setter
public class Resource<T> {

	private T content;
}
