package com.invoice.inventories.exceptions;

import com.invoice.inventories.models.InventoryErrorResponse;
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
import static com.invoice.inventories.exceptions.InventoryErrorCatalog.*;

@RestControllerAdvice
public class InventoryControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InventoryNotFoundException.class)
    public InventoryErrorResponse handleDiscountNotFoundException() {
        return InventoryErrorResponse.builder()
                .code(INVENTORY_NOT_FOUND.getCode())
                .message(INVENTORY_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

   /* @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public InventoryErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return InventoryErrorResponse.builder()
                .code(INVALID_INVENTORY.getCode())
                .message(INVALID_INVENTORY.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public InventoryErrorResponse handleGenericError(Exception exception) {
        return InventoryErrorResponse.builder()
                .code(GENERIC_INVENTORY_ERROR.getCode())
                .message(GENERIC_INVENTORY_ERROR.getMessage())
                .details(Collections.singletonList(exception.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }*/
}
