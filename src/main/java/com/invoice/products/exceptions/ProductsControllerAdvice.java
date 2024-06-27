package com.invoice.products.exceptions;


import com.invoice.products.models.ProductsErrorResponse;
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

import static com.invoice.products.exceptions.ProductsErrorCatalog.*;


@RestControllerAdvice
public class ProductsControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ProductsErrorResponse handleProductsNotFoundException() {
        return ProductsErrorResponse.builder()
                .code(PRODUCT_NOT_FOUND.getCode())
                .message(PRODUCT_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProductsErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return ProductsErrorResponse.builder()
                .code(INVALID_PRODUCT.getCode())
                .message(INVALID_PRODUCT.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ProductsErrorResponse handleGenericError(Exception exception) {
        return ProductsErrorResponse.builder()
                .code(GENERIC_PRODUCT_ERROR.getCode())
                .message(GENERIC_PRODUCT_ERROR.getMessage())
                .details(Collections.singletonList(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }*/
}
