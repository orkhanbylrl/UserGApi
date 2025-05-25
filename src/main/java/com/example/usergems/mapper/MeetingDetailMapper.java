package com.example.usergems.mapper;

import com.example.usergems.model.entity.MeetingDetailsEntity;
import com.example.usergems.model.response.MeetingDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MeetingDetailMapper {
    MeetingDetailMapper INSTANCE = Mappers.getMapper(MeetingDetailMapper.class);

    @Mapping(target = "name", expression = "java(meetingDetailEntity.getUser().getUserName())")
    @Mapping(source = "numberOfMeeting", target = "meetingCount")
    MeetingDetails toMeetingDetails(MeetingDetailsEntity meetingDetailEntity);
}
