package com.example.email.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @GetMapping("/emails/{userId}")
    public String getUserEmail(@PathVariable Integer userId) {
        return String.format("%d@rest.local", userId);
    }
}
