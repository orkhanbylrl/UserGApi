package com.example.usergems;

import com.example.usergems.model.response.Email;
import com.example.usergems.model.response.Person;
import com.example.usergems.service.EmailService;
import com.example.usergems.service.MeetingService;
import com.example.usergems.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
@EnableScheduling
public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }


}
