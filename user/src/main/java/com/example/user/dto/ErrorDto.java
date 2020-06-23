package com.example.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@Getter
public class ErrorDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> messages;

    public ErrorDto(String message) {
        this.message = message;
    }

    public ErrorDto(List<String> messages) {
        this.messages = messages;
    }
}
