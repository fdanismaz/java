package com.fcommons.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author fdanismaz
 * @since 11/26/19
 */
@Getter
@AllArgsConstructor
public enum FErrorType {

    Default("default-error"),
    Object("object-error"),
    Field("field-error");

    String value;
}
