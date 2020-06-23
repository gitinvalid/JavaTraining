package com.example.user.controller;

import com.example.user.converter.UserConverter;
import com.example.user.dto.UserDto;
import com.example.user.model.UserEntity;
import com.example.user.service.EmailService;
import com.example.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {UserController.class, UserConverter.class})
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmailService emailService;

    @MockBean
    private UserService userService;

    ObjectMapper MAPPER = new ObjectMapper();

    @Test
    void should_return_user_info_with_email_when_user_created() throws Exception {
        UserDto userDto = makeUserDto();
        UserEntity userEntity = makeUserEntity();
        given(userService.createUser(any(), any())).willReturn(userEntity);
        given(emailService.getEmail(any())).willReturn("email");

        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON)
                .content(MAPPER.writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(userDto.getName()))
                .andExpect(jsonPath("$.age").value(userDto.getAge()))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.createdAt").exists())
                .andExpect(jsonPath("$.updatedAt").exists())
                .andExpect(jsonPath("$.email").value("email"));
    }

    @Test
    void should_return_user_info_without_email_when_email_service_error() throws Exception {
        UserDto userDto = makeUserDto();
        UserEntity userEntity = makeUserEntity();
        given(userService.createUser(any(), any())).willReturn(userEntity);
        given(emailService.getEmail(any())).willReturn(null);

        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON)
                .content(MAPPER.writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(userDto.getName()))
                .andExpect(jsonPath("$.age").value(userDto.getAge()))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.createdAt").exists())
                .andExpect(jsonPath("$.updatedAt").exists())
                .andExpect(jsonPath("$.email").doesNotExist());
    }

    @Test
    void should_return_user_when_send_get_request_with_id() throws Exception {
        UserEntity userEntity = makeUserEntity();
        given(userService.getUser(any())).willReturn(userEntity);
        given(emailService.getEmail(any())).willReturn(null);

        mockMvc.perform(get("/users/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(userEntity.getName()))
                .andExpect(jsonPath("$.age").value(userEntity.getAge()))
                .andExpect(jsonPath("$.id").value(userEntity.getId()));
    }

    @Test
    void should_update_user_when_send_patch_request() throws Exception {
        UserDto userDto = makeUserDto();
        userDto.setName("new name");
        UserEntity userEntity = makeUserEntity();
        userEntity.setName(userDto.getName());
        given(userService.updateUser(any(),any(),any())).willReturn(userEntity);

        mockMvc.perform(patch("/users/1").contentType(MediaType.APPLICATION_JSON)
                .content(MAPPER.writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(userDto.getName()));
    }

    @Test
    void should_delete_success_when_delete() throws Exception {
        mockMvc.perform(delete("/users/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    private UserDto makeUserDto() {
        UserDto userDto = new UserDto();
        userDto.setAge(10);
        userDto.setName("TEST");
        return userDto;
    }

    private UserEntity makeUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setAge(10);
        userEntity.setName("TEST");
        userEntity.setCreatedAt(new Date());
        userEntity.setUpdatedAt(new Date());
        return userEntity;
    }

}
