package com.example.usergems.service;

import com.example.usergems.mapper.PersonMapper;
import com.example.usergems.model.entity.PersonEntity;
import com.example.usergems.model.response.Person;
import com.example.usergems.repository.PersonRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PersonService {
    PersonRepository personRepository;
    PersonApiService personApiService;

    public Optional<PersonEntity> getByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public void save(PersonEntity person) {
        personRepository.save(person);
    }

    public PersonEntity getCachedOrNew(String email, LocalDateTime customDate) {
        Optional<PersonEntity> cached = getByEmail(email);

        boolean refresh = cached.isEmpty() ||
                cached.get().getLastFetchedAt().toLocalDate().plusDays(30).isBefore(customDate.toLocalDate());

        if (refresh) {
            Person personInfo = personApiService.getPersonInfo(email);
            PersonEntity newEntity = PersonMapper.INSTANCE.toPersonEntity(personInfo, email);
            newEntity.setLastFetchedAt(LocalDateTime.now());
            save(newEntity);
            return newEntity;
        }

        return cached.get();
    }
}
