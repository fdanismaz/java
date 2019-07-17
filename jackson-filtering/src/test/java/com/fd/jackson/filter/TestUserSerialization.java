package com.fd.jackson.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fd.jackson.filter.model.User;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;

public class TestUserSerialization {

    @Test
    public void givenPasswordFieldIsIgnoredAtSerialization_whenUserIsSerialized_thenIgnored() throws JsonProcessingException {
        User user = User.builder()
                .firstName("furkan")
                .lastName("danismaz")
                .email("danismaz.furkan@gmail.com")
                .password("123456")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String userAsString = mapper.writeValueAsString(user);

        assertThat(userAsString, not(containsString("password")));
        assertThat(userAsString, not(containsString("123456")));
    }
}
