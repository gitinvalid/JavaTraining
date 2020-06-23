package com.example.user.service;

import com.example.user.exception.UserNotExistException;
import com.example.user.model.UserEntity;
import com.example.user.repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
            throw new UserNotExistException(userId);
        });
    }

    public UserEntity createUser(String userName, Integer age) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userName);
        userEntity.setAge(age);
        return userRepository.save(userEntity);
    }

    public UserEntity updateUser(Integer userId, String name, Integer age) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> {
            throw new UserNotExistException(userId);
        });

        if (!name.equals(userEntity.getName())) {
            userEntity.setName(name);
        }
        if (!age.equals(userEntity.getAge())) {
            userEntity.setAge(age);
        }

        return userRepository.save(userEntity);
    }

    public void deleteUser(Integer userId) {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException exception) {
            throw new UserNotExistException(userId);
        }
    }

    public Page<UserEntity> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Page<UserEntity> getUsersByName(String name, Pageable pageable) {
        return userRepository.findAllByName(name, pageable);
    }
}
