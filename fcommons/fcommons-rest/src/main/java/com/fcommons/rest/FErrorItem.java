package com.fcommons.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author fdanismaz
 * @since 11/26/19
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FErrorItem {

    private String title;
    private String message;
    private String type;
}
