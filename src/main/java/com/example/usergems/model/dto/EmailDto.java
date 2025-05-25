package com.example.usergems.model.dto;

import jakarta.persistence.Lob;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EmailDto(
        String recipient,
        String emailContentHtml,
        LocalDateTime sentAt
){

}
