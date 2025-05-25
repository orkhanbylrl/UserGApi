package com.example.usergems.service;

import com.example.usergems.client.CalendarClient;
import com.example.usergems.model.entity.PersonEntity;
import com.example.usergems.model.entity.UserEntity;
import com.example.usergems.model.response.Event;
import com.example.usergems.model.response.Person;
import com.example.usergems.util.DateTimeUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MeetingService {
    UserService userService;
    CalendarAPIService calendarAPIService;
    PersonService personService;
    PersonApiService personApiService;

    public void generateMeetingForUser(String email, String token, String date) {
        LocalDateTime customDate = DateTimeUtils.parseDateLocalDateTime(date);
        List<Event> userEvents = calendarAPIService.getUserEvents(token)
                .stream().filter(ev -> ev.start().toLocalDate().isEqual(customDate.toLocalDate())).toList();

        for(Event event : userEvents) {
            for (String s : event.accepted()) {
                if(!s.toLowerCase().contains("@usergems.com")) {
                    Optional<PersonEntity> byEmail = personService.getByEmail(s);
                    if(byEmail.isEmpty() ||
                            byEmail.get().getLastFetchedAt().toLocalDate()
                                    .isBefore(customDate.toLocalDate().minusDays(30))) {
                        Person personInfo = personApiService.getPersonInfo(byEmail.get().getEmail());
                        personService.save();

                    }
                }
            }

        }


    }


    public void generateMeeting(String date) {
        List<UserEntity> all = userService.getAll();
        LocalDateTime customDate = DateTimeUtils.parseDateLocalDateTime(date);
        for (UserEntity ue : all) {
            String email = ue.getEmail();
            String token = ue.getToken();
            List<Event> data = calendarClient.getEvents(null, "Bearer " + token)
                    .getData()
                    .stream().filter(ev -> ev.start().isEqual(customDate)).toList();
            List<String> accepted = data.get(0).accepted();

            for (String mail : accepted) {
                Optional<PersonEntity> byEmail = personService.getByEmail(mail);
                if (byEmail.isEmpty() || byEmail.get().getLastFetchedAt().isBefore(LocalDateTime.now())) {
                    personClient.getPersonInfo(email, "header token"); // save in db
                }
                PersonEntity personEntity = personService.getByEmail(email).get();
                // get all person datas
                // generate html or jsonb mail
                //send mail
                // make correction in meeting info
            }
        }
    }
}
