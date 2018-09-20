package com.fd.tryout.hystrix.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author fdanismaz
 * date: 9/20/18 10:57 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -1370535335902642073L;

    private String id;
    private String name;
    private String email;
}
