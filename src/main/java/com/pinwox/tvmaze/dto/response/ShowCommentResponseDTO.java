package com.pinwox.tvmaze.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowCommentResponseDTO {
    
    private String comment;
    private Integer rating;
    
}
