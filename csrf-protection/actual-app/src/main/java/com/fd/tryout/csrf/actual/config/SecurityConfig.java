package com.fd.tryout.csrf.actual.config;

import com.fd.tryout.csrf.actual.security.SampleAuthenticationProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author furkand
 * 10/16/2018 3:34 PM
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public AuthenticationProvider authenticationProvider() {
        return new SampleAuthenticationProvider();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        //http.csrf().disable();
    }
}
