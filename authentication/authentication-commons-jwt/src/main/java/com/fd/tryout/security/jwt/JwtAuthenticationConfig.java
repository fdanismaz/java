package com.fd.tryout.security.jwt;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author fdanismaz
 * date: 10/20/18 3:52 PM
 */
@Getter
@Configuration
@PropertySource("jwt.properties")
public class JwtAuthenticationConfig {

    @Value("${com.fd.security.jwt.url:/login}")
    private String url;

    @Value("${com.fd.security.jwt.header:Authorization}")
    private String header;

    @Value("${com.fd.security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${com.fd.security.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${com.fd.security.jwt.secret}")
    private String secret;
}
