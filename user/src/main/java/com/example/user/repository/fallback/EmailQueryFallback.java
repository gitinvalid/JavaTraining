package com.example.user.repository.fallback;

import com.example.user.repository.EmailRepository;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmailQueryFallback implements FallbackFactory<EmailRepository> {

  private static final Logger logger = LoggerFactory.getLogger(EmailQueryFallback.class);

  @Override
  public EmailRepository create(Throwable throwable) {
    logger.warn("query user email failed");
    return name -> null;
  }
}