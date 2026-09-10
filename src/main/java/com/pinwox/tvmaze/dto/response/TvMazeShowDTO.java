package com.pinwox.tvmaze.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TvMazeShowDTO {

    private Long id;
    private String url;
    private String name;
    private String type;
    private String language;
    private List<String> genres;
    private String status;
    private Integer runtime;
    private Integer averageRuntime;
    private String premiered;
    private String ended;
    private String officialSite;
    private TvMazeScheduleDTO schedule;
    private TvMazeRatingDTO rating;
    private Integer weight;
    private TvMazeNetworkDTO network;
    private TvMazeWebChannelDTO webChannel;
    private TvMazeCountryDTO dvdCountry;
    private TvMazeExternalsDTO externals;
    private TvMazeImageDTO image;
    private String summary;
    private Long updated;

    @JsonProperty("_links")
    private TvMazeLinksDTO links;

    private List<ShowCommentResponseDTO> comments;

}
