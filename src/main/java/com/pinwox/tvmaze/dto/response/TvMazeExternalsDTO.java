package com.pinwox.tvmaze.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TvMazeExternalsDTO {

    private Long tvrage;
    private Long thetvdb;
    private String imdb;
}
