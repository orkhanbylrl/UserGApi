package com.example.usergems.model.response;

import lombok.Builder;

import java.time.LocalTime;
import java.util.List;

@Builder
public record Email(
        LocalTime start,
        LocalTime end,
        String title,
        List<PersonMail> accepted,
        List<PersonMail> rejected
) {

}
