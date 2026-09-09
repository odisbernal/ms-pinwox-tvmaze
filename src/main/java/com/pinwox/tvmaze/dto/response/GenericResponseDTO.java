package com.pinwox.tvmaze.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenericResponseDTO<T> {

    private Boolean success;

    private String message;

    private Integer code;

    private T data;
}
