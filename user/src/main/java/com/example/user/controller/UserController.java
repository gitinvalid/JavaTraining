package com.example.user.controller;

import com.example.user.converter.UserConverter;
import com.example.user.dto.UserDto;
import com.example.user.model.UserEntity;
import com.example.user.service.EmailService;
import com.example.user.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserService userService;
    private final EmailService emailService;
    private final UserConverter userConverter;

    public UserController(UserService userService, EmailService emailService, UserConverter userConverter) {
        this.userService = userService;
        this.emailService = emailService;
        this.userConverter = userConverter;
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable Integer userId) {
        UserEntity userEntity = userService.getUser(userId);
        String email = emailService.getEmail(userId);
        UserDto userDto = userConverter.entityToDto(userEntity);
        userDto.setEmail(email);
        return userDto;
    }

    @GetMapping("/users")
    public List<UserDto> getUsers(@RequestParam(defaultValue = "") String name, @PageableDefault Pageable pageable) {
        if (!name.isEmpty()) {
            return userService.getUsersByName(name, pageable).stream().map(userConverter::entityToDto).peek(userDto -> {
                String email = emailService.getEmail(userDto.getId());
                userDto.setEmail(email);
            }).collect(Collectors.toList());
        }
        return userService.getUsers(pageable).stream().map(userConverter::entityToDto).collect(Collectors.toList());
    }

    @PostMapping("/user")
    public UserDto createUser(@RequestBody @Validated UserDto userDto) {
        UserEntity userEntity = userService.createUser(userDto.getName(), userDto.getAge());
        UserDto createdUserDto = userConverter.entityToDto(userEntity);
        String email = emailService.getEmail(createdUserDto.getId());
        createdUserDto.setEmail(email);
        return createdUserDto;
    }

    @PatchMapping("/users/{userId}")
    public UserDto updateUser(@PathVariable Integer userId, @RequestBody @Validated UserDto userDto) {
        UserEntity userEntity = userService.updateUser(userId, userDto.getName(), userDto.getAge());
        return userConverter.entityToDto(userEntity);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
