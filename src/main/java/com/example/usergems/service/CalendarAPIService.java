package com.example.usergems.service;

import com.example.usergems.client.CalendarClient;
import com.example.usergems.model.response.Event;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CalendarAPIService {
    CalendarClient calendarClient;

    public List<Event> getUserEvents(String token) {
        return calendarClient.getEvents(null, "Bearer " + token).getData();
    }
}
