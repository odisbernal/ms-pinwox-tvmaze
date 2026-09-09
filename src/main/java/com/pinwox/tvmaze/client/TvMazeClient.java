package com.pinwox.tvmaze.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClient;

import com.pinwox.tvmaze.dto.response.TvMazeSearchResponseDTO;

@Component
@RequiredArgsConstructor
public class TvMazeClient {

    private final RestClient restClient;

    public List<TvMazeSearchResponseDTO> searchShows(String searchQuery) {

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/shows")
                        .queryParam("q", searchQuery)
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<List<TvMazeSearchResponseDTO>>() {});
    }

}
