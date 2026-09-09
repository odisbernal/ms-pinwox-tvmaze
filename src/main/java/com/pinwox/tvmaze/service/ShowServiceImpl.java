package com.pinwox.tvmaze.service;

import java.util.List;

import com.pinwox.tvmaze.client.TvMazeClient;
import com.pinwox.tvmaze.dto.response.ShowResponseDTO;
import com.pinwox.tvmaze.dto.response.TvMazeSearchResponseDTO;
import com.pinwox.tvmaze.dto.response.TvMazeShowDTO;
import com.pinwox.tvmaze.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.pinwox.tvmaze.mapper.ShowMapper;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final TvMazeClient tvMazeClient;
    private final ShowMapper showMapper;

    @Override
    public List<ShowResponseDTO> searchShows(String searchQuery) {

        List<TvMazeSearchResponseDTO> tvMazeShows = tvMazeClient.searchShows(searchQuery);

        return tvMazeShows.stream()
                .map(response -> showMapper.toResponseDTO(response.getShow()))
                .toList();
    }

    @Override
    public TvMazeShowDTO getShowById(Long showId) {

        return tvMazeClient.getShowById(showId);

    }

}
