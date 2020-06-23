package com.example.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    Integer id;
    @NotNull
    @Size(min = 1, max = 64)
    String name;
    @NotNull
    @Min(1)
    Integer age;
    Date createdAt;
    Date updatedAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String email;
}
