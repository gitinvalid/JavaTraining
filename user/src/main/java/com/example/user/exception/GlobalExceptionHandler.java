package com.example.user.exception;

import com.example.user.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorDto> handleUserNotExist(GenericException exception) {
        logger.info(exception.getMessage());
        ErrorDto errorDto = new ErrorDto(exception.getMessage());
        return ResponseEntity.status(exception.getStatus()).body(errorDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleArgumentValidationException(MethodArgumentNotValidException exception) {
        logger.info(exception.getMessage());
        ErrorDto errorDto = makeErrorDto(exception.getBindingResult().getFieldErrors());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> handleRuntimeException(RuntimeException exception) {
        logger.info(String.format("%s: %s", exception.getClass().getName(), exception.getMessage()));
        ErrorDto errorDto = new ErrorDto("Internal server error, please try again later");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }

    private ErrorDto makeErrorDto(List<FieldError> errorFields) {
        List<String> errorMessages = new ArrayList<>();
        for (FieldError error : errorFields) {
            String errorMessage = String.format("%s: %s", error.getField(), error.getDefaultMessage());
            errorMessages.add(errorMessage);
        }

        if (errorMessages.size() == 1) {
            return new ErrorDto(errorMessages.get(0));
        }

        return new ErrorDto(errorMessages);
    }
}
