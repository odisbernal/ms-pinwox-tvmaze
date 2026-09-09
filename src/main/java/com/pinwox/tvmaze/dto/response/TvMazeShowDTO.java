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
public class TvMazeShowDTO {

    private Long id;
    private String name;
    private String summary;
    private List<String> genres;
    private TvMazeNetworkDTO network;
    private TvMazeWebChannelDTO webChannel;

}
