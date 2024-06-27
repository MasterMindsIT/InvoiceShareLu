package com.invoice.companies.exceptions;

import com.invoice.companies.models.CompanyErrorResponse;
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
import static com.invoice.companies.exceptions.CompanyErrorCatalog.*;

@RestControllerAdvice
public class CompanyControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CompanyNotFoundException.class)
    public CompanyErrorResponse handleCompanyNotFoundException() {
        return CompanyErrorResponse.builder()
                .code(COMPANY_NOT_FOUND.getCode())
                .message(COMPANY_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

   /* @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CompanyErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return CompanyErrorResponse.builder()
                .code(INVALID_COMPANY.getCode())
                .message(INVALID_COMPANY.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public CompanyErrorResponse handleGenericError(Exception exception) {
        return CompanyErrorResponse.builder()
                .code(GENERIC_COMPANY_ERROR.getCode())
                .message(GENERIC_COMPANY_ERROR.getMessage())
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