package com.invoice.categories.exceptions;

import com.invoice.categories.models.CategoryErrorResponse;
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

import static com.invoice.categories.exceptions.CategoryErrorCatalog.*;

@RestControllerAdvice
public class CategoryControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public CategoryErrorResponse handleCategoryNotFoundException() {
        return CategoryErrorResponse.builder()
                .code(CATEGORY_NOT_FOUND.getCode())
                .message(CATEGORY_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CategoryErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return CategoryErrorResponse.builder()
                .code(INVALID_CATEGORY.getCode())
                .message(INVALID_CATEGORY.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public CategoryErrorResponse handleGenericError(Exception exception) {
        return CategoryErrorResponse.builder()
                .code(GENERIC_CATEGORY_ERROR.getCode())
                .message(GENERIC_CATEGORY_ERROR.getMessage())
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
