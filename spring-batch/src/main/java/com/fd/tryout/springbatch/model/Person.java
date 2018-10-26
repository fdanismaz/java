package com.fd.tryout.springbatch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author furkand
 * 10/26/2018 6:03 PM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private String surname;
}
