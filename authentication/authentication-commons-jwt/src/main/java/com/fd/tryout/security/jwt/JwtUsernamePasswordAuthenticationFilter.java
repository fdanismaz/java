package com.fd.tryout.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.var;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fdanismaz
 * date: 10/20/18 4:33 PM
 */
public class JwtUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final JwtAuthenticationConfig config;
    private final ObjectMapper mapper;

    public JwtUsernamePasswordAuthenticationFilter(JwtAuthenticationConfig config,
                                                   AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(config.getUrl(), "POST"));
        this.setAuthenticationManager(authenticationManager);
        this.config = config;
        this.mapper = new ObjectMapper();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException {

        User user = this.mapper.readValue(request.getInputStream(), User.class);
        var authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), Collections.emptyList());
        return this.getAuthenticationManager().authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication auth) {
        String token = this.generateToken(auth);
        response.addHeader(config.getHeader(), config.getPrefix() + " " + token);
    }

    private String generateToken(Authentication auth) {
        Instant now = Instant.now();
        List<String> authorities = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        String token = Jwts.builder()
                .setSubject(auth.getName())
                .claim("authorities", authorities)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusSeconds(config.getExpiration())))
                .signWith(SignatureAlgorithm.HS256, config.getSecret().getBytes())
                .compact();
        return token;
    }

    @Data
    private class User {
        private String username;
        private String password;
    }
}
