package com.pinwox.tvmaze.service;

import java.util.List;

import com.pinwox.tvmaze.client.TvMazeClient;
import com.pinwox.tvmaze.dto.response.ShowCommentResponseDTO;
import com.pinwox.tvmaze.dto.response.ShowResponseDTO;
import com.pinwox.tvmaze.dto.response.TvMazeSearchResponseDTO;
import com.pinwox.tvmaze.dto.response.TvMazeShowDTO;
import com.pinwox.tvmaze.entity.Show;
import com.pinwox.tvmaze.entity.Comment;
import com.pinwox.tvmaze.mapper.CommentMapper;

import lombok.extern.slf4j.Slf4j;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.pinwox.tvmaze.mapper.ShowMapper;
import com.pinwox.tvmaze.repository.CommentRepository;
import com.pinwox.tvmaze.repository.ShowRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final TvMazeClient tvMazeClient;
    private final ShowMapper showMapper;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;;

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

        Optional<Show> showPersistence = showRepository.findById(showId);

        TvMazeShowDTO show;

        if (showPersistence.isPresent()) {

            show = showMapper.toTvMazeShowDTO(
                    showPersistence.get());
        } else {
            show = tvMazeClient.getShowById(showId);
            showRepository.save(
                    showMapper.toEntity(show));
            log.info(
                    "Show con id {} guardado en MongoDB",
                    showId);
        }

        List<Comment> comments = commentRepository.findByShowId(showId);

        show.setComments(
                comments.stream()
                        .map(commentMapper::toShowCommentResponseDTO)
                        .toList());
        //Se agrega libreria para spring automatico de cambios

        return show;
    }

}
