package com.example.usergems;

import com.example.usergems.model.response.Person;
import com.example.usergems.service.EmailService;
import com.example.usergems.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
public class Launcher implements CommandLineRunner {

    private final EmailService emailService;
    private final UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Person person = emailService.getPerson("demi@algolia.com");
//        System.out.println(person);
//        userService.getLatestEvents().getData().forEach(System.out::println);
    }
}
