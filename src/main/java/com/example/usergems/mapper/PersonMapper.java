package com.example.usergems.mapper;

import com.example.usergems.model.entity.CompanyObj;
import com.example.usergems.model.entity.MeetingDetailsEntity;
import com.example.usergems.model.entity.PersonEntity;
import com.example.usergems.model.response.Company;
import com.example.usergems.model.response.MeetingDetails;
import com.example.usergems.model.response.Person;
import com.example.usergems.model.response.PersonMail;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);


    @Mappings({
            @Mapping(source = "avatar", target = "avatarLink"),
            @Mapping(source = "linkedinUrl", target = "linkedinUrl"),
            @Mapping(source = "company", target = "company")
    })
    PersonEntity toPersonEntity(Person person, @Context String email);

    @AfterMapping
    default void setEmail(@MappingTarget PersonEntity target, @Context String email) {
        target.setEmail(email);
    }

    @Mappings({
            @Mapping(source = "name", target = "companyName"),
            @Mapping(source = "linkedinUrl", target = "companyLinkedinUrl"),
            @Mapping(source = "employees", target = "employees")
    })
    CompanyObj toCompanyObj(Company company);

    @Mapping(target = "fullName", expression = "java(personEntity.getFirstName() + \" \" + personEntity.getLastName())")
    @Mapping(source = "avatarLink", target = "avatar")
    @Mapping(source = "title", target = "title")
    @Mapping(target = "meetingDetail", ignore = true)
    PersonMail toPerson(PersonEntity personEntity, @Context List<MeetingDetails> details);

    @AfterMapping
    default void injectMeetingDetails(@MappingTarget PersonMail target, @Context List<MeetingDetails> details) {
        target.setMeetingDetail(details);
    }


}
