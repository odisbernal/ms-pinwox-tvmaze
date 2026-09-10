package com.pinwox.tvmaze.service;

import java.util.List;

import com.pinwox.tvmaze.client.TvMazeClient;
import com.pinwox.tvmaze.dto.response.ShowCommentResponseDTO;
import com.pinwox.tvmaze.dto.response.ShowResponseDTO;
import com.pinwox.tvmaze.dto.response.TvMazeSearchResponseDTO;
import com.pinwox.tvmaze.dto.response.TvMazeShowDTO;
import com.pinwox.tvmaze.entity.Show;
import com.pinwox.tvmaze.entity.Comment;

import lombok.extern.slf4j.Slf4j;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pinwox.tvmaze.mapper.ShowMapper;
import com.pinwox.tvmaze.repository.CommentRepository;
import com.pinwox.tvmaze.repository.ShowRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    private final TvMazeClient tvMazeClient;
    private final ShowMapper showMapper;
    private final CommentRepository commentRepository;

    @Override
    public List<ShowResponseDTO> searchShows(String searchQuery) {

        List<TvMazeSearchResponseDTO> tvMazeShows = tvMazeClient.searchShows(searchQuery);

        return tvMazeShows.stream()
                .map(response -> {

                    TvMazeShowDTO show = response.getShow();

                    List<Comment> comments = commentRepository.findByShowId(show.getId());

                    ShowResponseDTO showResponse = showMapper.toResponseDTO(show);

                    List<ShowCommentResponseDTO> commentResponses = comments.stream()
                            .map(comment -> ShowCommentResponseDTO.builder()
                                    .comment(comment.getComment())
                                    .rating(comment.getRating())
                                    .build())
                            .toList();

                    showResponse.setComments(commentResponses);

                    return showResponse;
                })
                .toList();
    }

    @Override
    public TvMazeShowDTO getShowById(Long showId) {

        log.info("Consultando show con id {} en MongoDB", showId);

        Optional<Show> showPersistence = showRepository.findById(showId);

        if (showPersistence.isPresent()) {

            log.info("Show con id {} encontrado en cache MongoDB", showId);

            return showMapper.toTvMazeShowDTO(showPersistence.get());
        }

        log.info(
                "Show con id {} no encontrado en MongoDB. Consultando API TVMaze",
                showId);

        TvMazeShowDTO show = tvMazeClient.getShowById(showId);

        showRepository.save(
                showMapper.toEntity(show));

        return show;
    }

}
