package com.example.usergems.service;

import com.example.usergems.model.entity.UserEntity;
import com.example.usergems.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}
