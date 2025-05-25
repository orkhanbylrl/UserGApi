package com.example.usergems.client;

import com.example.usergems.model.response.ApiResponse;
import com.example.usergems.model.response.Event;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "calendarClient", url = "https://app.usergems.com/api/hiring/calendar-challenge/events")
public interface CalendarClient {

    @GetMapping
    ApiResponse<List<Event>> getEvents(
            @RequestParam("page") Integer page,
            @RequestHeader("Authorization") String authHeader
    );
}

