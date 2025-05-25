package com.example.usergems.mapper;

import com.example.usergems.model.entity.PersonEntity;
import com.example.usergems.model.response.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonEntity toPersonEntity(Person person);
}
