package com.example.usergems.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record Event(
        Long id,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime changed,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime start,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime end,
        String title,
        List<String> accepted,
        List<String> rejected
) {
}
