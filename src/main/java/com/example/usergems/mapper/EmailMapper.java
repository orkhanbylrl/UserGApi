package com.example.usergems.mapper;

import com.example.usergems.model.dto.EmailDto;
import com.example.usergems.model.entity.EmailEntity;
import org.mapstruct.factory.Mappers;

public interface EmailMapper {
    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    EmailEntity toEntity(EmailDto emailDto);
}
