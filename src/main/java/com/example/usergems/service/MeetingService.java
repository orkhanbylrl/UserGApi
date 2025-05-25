package com.example.usergems.service;

import com.example.usergems.mapper.PersonMapper;
import com.example.usergems.model.entity.PersonEntity;
import com.example.usergems.model.response.Email;
import com.example.usergems.model.response.Event;
import com.example.usergems.model.response.MeetingDetails;
import com.example.usergems.model.response.PersonMail;
import com.example.usergems.util.ApplicationConstants;
import com.example.usergems.util.DateTimeUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MeetingService {
    CalendarAPIService calendarAPIService;
    PersonService personService;
    MeetingDetailsService meetingDetailsService;



    public List<Email> generateMeetingForUser(String email, String token, String date) { // for testing purpose date is extracted
        LocalDateTime customDate = DateTimeUtils.parseDateLocalDateTime(date);
        List<Event> userEvents = calendarAPIService.getUserEvents(token)
                .stream()
                .filter(ev -> ev.start().toLocalDate().isEqual(customDate.toLocalDate()))
                .toList();

        List<Email> emails = new ArrayList<>();

        for (Event event : userEvents) {
            List<PersonMail> accepted = personMapper(event.accepted(), customDate, email);
            List<PersonMail> rejected = personMapper(event.rejected(), customDate, email);

            Email emailData = Email.builder()
                    .title(event.title())
                    .start(event.start().toLocalTime())
                    .end(event.end().toLocalTime())
                    .accepted(accepted)
                    .rejected(rejected)
                    .build();

            emails.add(emailData);
        }

        return emails;
    }

    public List<PersonMail> personMapper(List<String> data, LocalDateTime customDate, String email) {
        List<PersonMail> resultList = new ArrayList<>();
        for (String acceptedEmail : data) {
            if (!acceptedEmail.toLowerCase().contains(ApplicationConstants.COMPANY_MAIL_DOMAIN)) {
                PersonEntity personEntity = personService.getCachedOrNew(acceptedEmail, customDate);
                List<MeetingDetails> details = meetingDetailsService.getByPersonId(personEntity.getId(), email);
                PersonMail person = PersonMapper.INSTANCE.toPerson(personEntity, details);
                resultList.add(person);
            }
        }
        return resultList;
    }

}
