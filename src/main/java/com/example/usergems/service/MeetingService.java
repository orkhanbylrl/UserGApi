package com.example.usergems.service;

import com.example.usergems.client.CalendarClient;
import com.example.usergems.mapper.PersonMapper;
import com.example.usergems.model.entity.PersonEntity;
import com.example.usergems.model.entity.UserEntity;
import com.example.usergems.model.response.Email;
import com.example.usergems.model.response.Event;
import com.example.usergems.model.response.Person;
import com.example.usergems.util.DateTimeUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
                    PersonEntity cachedOrNew = getCachedOrNew(s, customDate);

                }
            }
        }

    }

    public PersonEntity getCachedOrNew(String email, LocalDateTime customDate) {
        Optional<PersonEntity> cached = personService.getByEmail(email);

        boolean refresh = cached.isEmpty() ||
                cached.get().getLastFetchedAt().toLocalDate().isBefore(customDate.toLocalDate().minusDays(30));

        if (refresh) {
            Person personInfo = personApiService.getPersonInfo(email);
            PersonEntity newEntity = PersonMapper.INSTANCE.toPersonEntity(personInfo);
            newEntity.setLastFetchedAt(LocalDateTime.now());
            personService.save(newEntity);
            return newEntity;
        }

        return cached.get();
    }



// get all person datas
    // generate html or jsonb mail
    //send mail
    // make correction in meeting info
}
