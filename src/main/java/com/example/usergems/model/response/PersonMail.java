package com.example.usergems.model.response;

import java.util.List;

public record PersonMail(
        String fullName,
        String title,
        String avatar,
        String totalMeetingCount,
        List<MeetingDetail> meetingDetail
) {
}
