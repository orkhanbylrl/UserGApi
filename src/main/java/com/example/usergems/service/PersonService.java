package com.example.usergems.service;

import com.example.usergems.model.entity.PersonEntity;
import com.example.usergems.model.response.Person;
import com.example.usergems.repository.PersonRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PersonService {
    PersonRepository personRepository;

    public Optional<PersonEntity> getByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public void save(PersonEntity person) {
        personRepository.save(person);
    }
}
