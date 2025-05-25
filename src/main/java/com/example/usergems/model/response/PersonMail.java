package com.example.usergems.model.response;

import lombok.Data;

import java.util.List;

@Data
public class PersonMail {
    String fullName;
    String title;
    String avatar;
    Integer totalMeetingCount;
    List<MeetingDetails> meetingDetail;
}
