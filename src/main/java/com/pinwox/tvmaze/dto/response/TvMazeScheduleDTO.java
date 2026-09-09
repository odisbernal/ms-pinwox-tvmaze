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
public class TvMazeScheduleDTO {

    private String time;
    private List<String> days;

}
