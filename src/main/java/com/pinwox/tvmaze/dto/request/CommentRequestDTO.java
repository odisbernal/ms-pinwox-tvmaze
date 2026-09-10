package com.pinwox.tvmaze.dto.request;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDTO {
    
    private Long showId;
    private String comment;
    private Integer rating;

}
