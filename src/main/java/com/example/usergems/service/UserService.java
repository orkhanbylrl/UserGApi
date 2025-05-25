package com.example.usergems.service;

import com.example.usergems.client.CalendarClient;
import com.example.usergems.client.PersonClient;
import com.example.usergems.model.entity.PersonEntity;
import com.example.usergems.model.entity.UserEntity;
import com.example.usergems.model.response.ApiResponse;
import com.example.usergems.model.response.Event;
import com.example.usergems.repository.PersonRepository;
import com.example.usergems.repository.UserRepository;
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
public class UserService {
    UserRepository userRepository;
    CalendarClient calendarClient;
    PersonClient personClient;
    PersonService personService;

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }


    public void processUsers() {




    }

}
