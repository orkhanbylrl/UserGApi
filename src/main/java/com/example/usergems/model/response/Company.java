package com.example.usergems.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Company(
        String name,
        @JsonProperty("linkedin_url")
        String linkedinUrl,
        Integer employees
) {
}
