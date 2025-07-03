package models;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;

public record UserCreateResponse(
        @JsonProperty("id") int id,
        @JsonProperty("username") String username,
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("email") String email,
        @JsonProperty("password") String password,
        @JsonProperty("phone") String phone,
        @JsonProperty("userStatus") int userStatus
) {}