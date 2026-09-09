package com.pinwox.tvmaze.mapper;

import org.springframework.stereotype.Component;

import com.pinwox.tvmaze.dto.response.ShowResponseDTO;
import com.pinwox.tvmaze.dto.response.TvMazeShowDTO;


@Component
public class ShowMapper {

        public ShowResponseDTO toResponseDTO(TvMazeShowDTO show) {

        String channel = null;

        if (show.getNetwork() != null) {
            channel = show.getNetwork().getName();
        } else if (show.getWebChannel() != null) {
            channel = show.getWebChannel().getName();
        }

        return ShowResponseDTO.builder()
                .id(show.getId())
                .name(show.getName())
                .channel(channel)
                .summary(show.getSummary())
                .genres(show.getGenres())
                .build();
    }


}
