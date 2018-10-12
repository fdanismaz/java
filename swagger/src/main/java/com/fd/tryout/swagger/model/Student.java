package com.fd.tryout.swagger.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fdanismaz
 * date: 10/12/18 7:35 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String id;
    private String name;
    private String surname;
}
