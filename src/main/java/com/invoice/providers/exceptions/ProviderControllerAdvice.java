package com.invoice.providers.exceptions;


import com.invoice.providers.models.ProviderErrorResponse;
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

import static com.invoice.providers.exceptions.ProviderErrorCatalog.*;

@RestControllerAdvice
public class ProviderControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProviderNotFoundException.class)
    public ProviderErrorResponse handleProviderNotFoundException() {
        return ProviderErrorResponse.builder()
                .code(PROVIDER_NOT_FOUND.getCode())
                .message(PROVIDER_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

  /*  @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProviderErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return ProviderErrorResponse.builder()
                .code(INVALID_PROVIDER.getCode())
                .message(INVALID_PROVIDER.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ProviderErrorResponse handleGenericError(Exception exception) {
        return ProviderErrorResponse.builder()
                .code(GENERIC_PROVIDER_ERROR.getCode())
                .message(GENERIC_PROVIDER_ERROR.getMessage())
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
