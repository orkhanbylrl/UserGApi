package com.example.usergems.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Person(
    @JsonProperty("first_name")
    String firstName,
    @JsonProperty("last_name")
    String lastName,
    String avatar,
    String title,
    @JsonProperty("linkedin_url")
    String linkedinUrl,
    Company company
) {
}
