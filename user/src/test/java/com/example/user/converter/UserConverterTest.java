package com.example.user.converter;

import com.example.user.dto.UserDto;
import com.example.user.fixture.User;
import com.example.user.model.UserEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserConverterTest {
    private final UserConverter userConverter = new UserConverter();

    @Test
    void givenUserConverter_whenInputUserEntity_shouldReturnUserDto() {
        UserEntity userEntity = User.makeUserEntity();
        UserDto userDto = userConverter.entityToDto(userEntity);

        assertEquals(userEntity.getId(), userDto.getId());
        assertEquals(userEntity.getAge(), userDto.getAge());
        assertEquals(userEntity.getName(), userDto.getName());
        assertEquals(userEntity.getCreatedAt(), userDto.getCreatedAt());
        assertEquals(userEntity.getUpdatedAt(), userDto.getUpdatedAt());
    }
}
