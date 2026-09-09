package com.pinwox.tvmaze.util;

import com.pinwox.tvmaze.dto.response.GenericResponseDTO;

public class ResponseBuilder {

    private ResponseBuilder() {
    }

    public static <T> GenericResponseDTO<T> success(T data) {

        return GenericResponseDTO.<T>builder()
                .success(true)
                .message("Operation successful")
                .code(200)
                .data(data)
                .build();
    }

    public static <T> GenericResponseDTO<T> created(T data) {

        return GenericResponseDTO.<T>builder()
                .success(true)
                .message("Resource created")
                .code(201)
                .data(data)
                .build();
    }

    public static <T> GenericResponseDTO<T> error(
            String message,
            Integer code) {

        return GenericResponseDTO.<T>builder()
                .success(false)
                .message(message)
                .code(code)
                .build();
    }
}