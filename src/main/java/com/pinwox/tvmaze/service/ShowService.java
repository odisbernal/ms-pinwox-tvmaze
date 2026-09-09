package com.pinwox.tvmaze.service;

import java.util.List;

import com.pinwox.tvmaze.dto.response.ShowResponseDTO;

public interface ShowService {


    List<ShowResponseDTO> searchShows(String searchQuery);

}
