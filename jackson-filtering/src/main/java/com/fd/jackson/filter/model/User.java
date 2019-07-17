package com.fd.jackson.filter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String firstName;
    private String lastName;
    private String password;
    private String email;

    /**
     * We use @JsonProperty here to enable Jackson de-serialization for the
     * password field. If we don't put @JsonProperty, the password field will
     * be ignored during both serialization and de-serialization
     *
     * @param password The password
     */
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * When used together with @JsonProperty on the setter method, using @JsonIgnore
     * on the getter method will only ignore the field during serialization.
     *
     * @return the password
     */
    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
