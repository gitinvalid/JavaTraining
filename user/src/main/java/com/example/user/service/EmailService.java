package com.example.user.service;

import com.example.user.exception.UserNotExistException;
import com.example.user.model.UserEntity;
import com.example.user.repository.EmailRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }


    public String getEmail(Integer userId) {
        return emailRepository.getEmail(userId);
    }
}
