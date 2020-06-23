package com.example.user.converter;

import com.example.user.dto.UserDto;
import com.example.user.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDto entityToDto(UserEntity userEntity) {
        return new UserDto(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getAge(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt(),
                null
        );
    }
}
