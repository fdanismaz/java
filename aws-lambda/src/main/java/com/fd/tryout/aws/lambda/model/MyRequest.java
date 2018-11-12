package com.fd.tryout.aws.lambda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fdanismaz
 * date: 11/11/18 5:06 PM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyRequest {

    private String name;
    private String surname;

}
