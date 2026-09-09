package com.pinwox.tvmaze.service;

import java.util.List;

import com.pinwox.tvmaze.dto.response.ShowResponseDTO;
import com.pinwox.tvmaze.dto.response.TvMazeShowDTO;

public interface ShowService {

    List<ShowResponseDTO> searchShows(String searchQuery);

    TvMazeShowDTO getShowById(Long showId);

}
