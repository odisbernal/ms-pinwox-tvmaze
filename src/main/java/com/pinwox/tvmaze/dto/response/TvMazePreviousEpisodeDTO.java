package com.pinwox.tvmaze.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TvMazePreviousEpisodeDTO {

    private String href;
    private String name;
}
