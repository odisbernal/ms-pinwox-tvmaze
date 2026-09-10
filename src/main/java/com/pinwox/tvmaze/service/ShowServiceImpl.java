package com.pinwox.tvmaze.service;

import java.util.List;

import com.pinwox.tvmaze.client.TvMazeClient;
import com.pinwox.tvmaze.dto.response.ShowResponseDTO;
import com.pinwox.tvmaze.dto.response.TvMazeSearchResponseDTO;
import com.pinwox.tvmaze.dto.response.TvMazeShowDTO;
import com.pinwox.tvmaze.entity.Show;
import lombok.extern.slf4j.Slf4j;


import lombok.RequiredArgsConstructor;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pinwox.tvmaze.mapper.ShowMapper;
import com.pinwox.tvmaze.repository.ShowRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

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

        Optional<Show> showPersistence = showRepository.findById(showId);

        if (showPersistence.isPresent()) {
            log.info("Consultando Mongo: {}", showId);
            return showMapper.toTvMazeShowDTO(showPersistence.get());
        }
            log.info("Consultando API: {}", showId);
        TvMazeShowDTO show = tvMazeClient.getShowById(showId);

        showRepository.save(showMapper.toEntity(show));

        return show;
    }

}
