package com.pinwox.tvmaze.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.pinwox.tvmaze.dto.response.TvMazeSearchResponseDTO;
import com.pinwox.tvmaze.dto.response.TvMazeShowDTO;
import com.pinwox.tvmaze.exception.ResourceNotFoundException;

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
                .body(new ParameterizedTypeReference<List<TvMazeSearchResponseDTO>>() {
                });
    }

    public TvMazeShowDTO getShowById(Long showId) {

        try {

            return restClient.get()
                    .uri("/shows/{showId}", showId)
                    .retrieve()
                    .body(TvMazeShowDTO.class);

        } catch (HttpClientErrorException.NotFound ex) {

            throw new ResourceNotFoundException(
                    "No se encontró el show con el ID: " + showId);
        }
    }

}
