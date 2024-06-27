package com.invoice.taxes.exceptions;

import com.invoice.taxes.models.TaxesErrorResponse;
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

import static com.invoice.taxes.exceptions.TaxesErrorCatalog.*;

@RestControllerAdvice
public class TaxesControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TaxesNotFoundException.class)
    public TaxesErrorResponse handleTaxesNotFoundException() {
        return TaxesErrorResponse.builder()
                .code(TAXES_NOT_FOUND.getCode())
                .message(TAXES_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

   /* @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public TaxesErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return TaxesErrorResponse.builder()
                .code(INVALID_TAXES.getCode())
                .message(INVALID_TAXES.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public TaxesErrorResponse handleGenericError(Exception exception) {
        return TaxesErrorResponse.builder()
                .code(GENERIC_TAXES_ERROR.getCode())
                .message(GENERIC_TAXES_ERROR.getMessage())
                .details(Collections.singletonList(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }*/
}
