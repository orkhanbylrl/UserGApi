package com.example.usergems.client;

import com.example.usergems.model.response.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "personClient",
        url = "https://app.usergems.com/api/hiring/calendar-challenge/person"
)
public interface PersonClient {

    @GetMapping("/{email}")
    Person getPersonInfo(
            @PathVariable("email") String email,
            @RequestHeader("Authorization") String authHeader
    );
}
