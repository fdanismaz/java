package com.fcommons.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fdanismaz
 * @since 11/26/19
 */
@Getter
@Setter
@AllArgsConstructor
public class FErrorContainer {

    private List<FErrorItem> errors;

    public FErrorContainer() {
        this.errors = new ArrayList<>();
    }

    public void addError(FErrorItem error) {
        this.errors.add(error);
    }

}
