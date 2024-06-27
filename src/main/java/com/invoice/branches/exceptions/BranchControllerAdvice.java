package com.invoice.branches.exceptions;

import com.invoice.branches.models.BranchErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import static com.invoice.branches.exceptions.BranchErrorCatalog.*;

@RestControllerAdvice
public class BranchControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BranchNotFoundException.class)
    public BranchErrorResponse handleBranchNotFoundException() {
        System.out.println("La cago");
        return BranchErrorResponse.builder()
                .code(BRANCH_NOT_FOUND.getCode())
                .message(BRANCH_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BranchErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return BranchErrorResponse.builder()
                .code(INVALID_BRANCH.getCode())
                .message(INVALID_BRANCH.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public BranchErrorResponse handleGenericError(Exception exception) {
        return BranchErrorResponse.builder()
                .code(GENERIC_BRANCH_ERROR.getCode())
                .message(GENERIC_BRANCH_ERROR.getMessage())
                .details(Collections.singletonList(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleFieldErrors(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return errors;
    }
}