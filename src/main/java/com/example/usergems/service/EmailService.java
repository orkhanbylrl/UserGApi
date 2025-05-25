package com.example.usergems.service;

import com.example.usergems.client.CalendarClient;
import com.example.usergems.client.PersonClient;
import com.example.usergems.model.entity.UserEntity;
import com.example.usergems.model.response.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final PersonClient personClient;
    private UserService userService;

    public Person getPerson(String email) {
        return personClient.getPersonInfo(email, "Bearer 9d^XItOjTAGSG5ch");
    }

    public void sendEmail() {


    }
}
