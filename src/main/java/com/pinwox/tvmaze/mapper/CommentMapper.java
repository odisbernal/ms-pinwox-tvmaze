package com.pinwox.tvmaze.mapper;

import org.springframework.stereotype.Component;

import com.pinwox.tvmaze.dto.request.CommentRequestDTO;
import com.pinwox.tvmaze.dto.response.CommentResponseDTO;
import com.pinwox.tvmaze.dto.response.ShowCommentResponseDTO;
import com.pinwox.tvmaze.entity.Comment;

@Component
public class CommentMapper {

    public Comment toEntity(CommentRequestDTO request) {

        if (request == null) {
            return null;
        }

        return Comment.builder()
                .showId(request.getShowId())
                .comment(request.getComment())
                .rating(request.getRating())
                .build();
    }

    public CommentResponseDTO toResponseDTO(Comment entity) {

        if (entity == null) {
            return null;
        }

        return CommentResponseDTO.builder()
                .id(entity.getId().toString())
                .showId(entity.getShowId())
                .comment(entity.getComment())
                .rating(entity.getRating())
                .creationDate(entity.getCreationDate())
                .build();
    }

    public ShowCommentResponseDTO toShowCommentResponseDTO(Comment entity) {

        if (entity == null) {
            return null;
        }

        return ShowCommentResponseDTO.builder()
                .comment(entity.getComment())
                .rating(entity.getRating())
                .build();
    }
}
