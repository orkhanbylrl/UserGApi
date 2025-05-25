package com.example.usergems.service;

import com.example.usergems.client.PersonClient;
import com.example.usergems.model.response.Person;
import com.example.usergems.util.ApplicationConstants;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PersonApiService {
    PersonClient personClient;

    public Person getPersonInfo(String email) {
        return personClient.getPersonInfo(email, "Bearer " + ApplicationConstants.PERSON_TOKEN);
    }
}
