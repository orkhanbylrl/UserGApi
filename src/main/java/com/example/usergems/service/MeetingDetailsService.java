package com.example.usergems.service;

import com.example.usergems.mapper.MeetingDetailMapper;
import com.example.usergems.model.response.MeetingDetails;
import com.example.usergems.repository.MeetingDetailsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MeetingDetailsService {
    MeetingDetailsRepository meetingDetailsRepo;

    public List<MeetingDetails> getByPersonId(Long id, String mail) {
        return meetingDetailsRepo.getMeetingDetails(id, mail).stream()
                .map(MeetingDetailMapper.INSTANCE::toMeetingDetails).toList();
    }
}
