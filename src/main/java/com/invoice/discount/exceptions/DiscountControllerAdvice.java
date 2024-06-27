package com.invoice.discount.exceptions;

import com.invoice.discount.models.DiscountErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.invoice.discount.exceptions.DiscountErrorCatalog.*;

@RestControllerAdvice
public class DiscountControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DiscountNotFoundException.class)
    public DiscountErrorResponse handleDiscountNotFoundException() {
        return DiscountErrorResponse.builder()
                .code(DISCOUNT_NOT_FOUND.getCode())
                .message(DISCOUNT_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DiscountErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return DiscountErrorResponse.builder()
                .code(INVALID_DISCOUNT.getCode())
                .message(INVALID_DISCOUNT.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public DiscountErrorResponse handleGenericError(Exception exception) {
        return DiscountErrorResponse.builder()
                .code(GENERIC_DISCOUNT_ERROR.getCode())
                .message(GENERIC_DISCOUNT_ERROR.getMessage())
                .details(Collections.singletonList(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }*/
}
