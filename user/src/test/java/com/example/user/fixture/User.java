package com.example.user.fixture;

import com.example.user.model.UserEntity;

import java.util.Date;

public class User {

    public static Integer USER_ID = 1;
    public static Integer USER_AGE = 10;
    public static String USER_NAME = "user";
    public static Date USER_CREATED = new Date();
    public static Date USER_UPDATED = new Date();

    public static UserEntity makeUserEntity() {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(USER_ID);
        userEntity.setAge(USER_AGE);
        userEntity.setName(USER_NAME);
        userEntity.setCreatedAt(USER_CREATED);
        userEntity.setCreatedAt(USER_UPDATED);

        return userEntity;
    }
}
