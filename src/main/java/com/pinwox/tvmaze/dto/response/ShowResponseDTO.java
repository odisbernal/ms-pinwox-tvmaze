package com.pinwox.tvmaze.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowResponseDTO {

    private Long id;
    private String name;
    private String channel;
    private String summary;
    private List<String> genres;
    //Nuevo campo agregado
    private List<ShowCommentResponseDTO> comments;
}
