package com.example.ecommerce.common.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Response {
    public static <T> ResponseEntity<SuccessResponse<T>> success(HttpStatus httpStatus, T data) {
        SuccessResponse<T> response = SuccessResponse.<T>builder()
                .data(data)
                .build();
        return ResponseEntity.status(httpStatus.value()).body(response);
    }

    public static <T> ResponseEntity<SuccessResponse<T>> success(T data) {
        return success(HttpStatus.OK, data);
    }

    public static ResponseEntity<ErrorResponse> error(HttpStatus httpStatus, List<String> messages) {
        ErrorResponse response = ErrorResponse.builder()
                .messages(messages)
                .code(httpStatus.value())
                .build();
        return ResponseEntity.status(httpStatus.value()).body(response);
    }

    public static ResponseEntity<ErrorResponse> error(List<String> messages) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, messages);
    }

    public static ResponseEntity<ErrorResponse> error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, List.of("Something went wrong"));
    }
}
