package com.example.user.repository;

import com.example.user.repository.fallback.EmailQueryFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "email", fallbackFactory = EmailQueryFallback.class)
public interface EmailRepository {
    @GetMapping("/emails/{userId}")
    String getEmail(@PathVariable("userId") Integer userId);
}