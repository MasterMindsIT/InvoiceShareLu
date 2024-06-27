package com.invoice.brands.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import com.invoice.brands.models.BrandsErrorResponse;
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

import static com.invoice.brands.exceptions.BrandsErrorCatalog.*;

@RestControllerAdvice
public class BrandsControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BrandNotFounfException.class)
    public BrandsErrorResponse handleBrandsNotFoundException() {
        return BrandsErrorResponse.builder()
                .code(BRANDS_NOT_FOUND.getCode())
                .message(BRANDS_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BrandsErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return BrandsErrorResponse.builder()
                .code(INVALID_BRANDS.getCode())
                .message(INVALID_BRANDS.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public BrandsErrorResponse handleGenericError(Exception exception) {
        return BrandsErrorResponse.builder()
                .code(GENERIC_BRAND_ERROR.getCode())
                .message(GENERIC_BRAND_ERROR.getMessage())
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
