package com.pinwox.tvmaze.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TvMazeNetworkDTO {

    private Long id;
    private String name;
    private TvMazeCountryDTO country;
    private String officialSite;

}
