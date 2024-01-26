package com.kav.CrudeApiService.handler;

import com.kav.CrudeApiService.dto.ErrorDto;
import com.kav.CrudeApiService.exception.DuplicateUserException;
import com.kav.CrudeApiService.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserErrorHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDto handleUserNotFoundException(UserNotFoundException exception){
        return ErrorDto.builder()
                .status("Failed")
                .errorMessage(exception.getMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(DuplicateUserException.class)
    public ProblemDetail handleDuplicateUserException(DuplicateUserException exception){
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleInvalidArgsException(MethodArgumentNotValidException exception){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
}
