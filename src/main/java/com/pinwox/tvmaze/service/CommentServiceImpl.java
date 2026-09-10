package com.pinwox.tvmaze.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.pinwox.tvmaze.dto.request.CommentRequestDTO;
import com.pinwox.tvmaze.dto.response.CommentResponseDTO;
import com.pinwox.tvmaze.entity.Comment;
import com.pinwox.tvmaze.exception.ResourceNotFoundException;
import com.pinwox.tvmaze.mapper.CommentMapper;
import com.pinwox.tvmaze.repository.CommentRepository;
import com.pinwox.tvmaze.repository.ShowRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ShowRepository showRepository;
    private final CommentMapper commentMapper;

    @Override
    public CommentResponseDTO saveComment(CommentRequestDTO request) {

        log.info("Registrando comentario para show id: {}", request.getShowId());

        if (!showRepository.existsById(request.getShowId())) {

            log.warn(
                    "No se puede registrar comentario. Show id {} no existe en MongoDB",
                    request.getShowId());

            throw new ResourceNotFoundException(
                    "No se encontró el show con el ID: " + request.getShowId());
        }

        Comment comment = commentMapper.toEntity(request);

        comment.setCreationDate(LocalDateTime.now());

        Comment savedComment = commentRepository.save(comment);

        return commentMapper.toResponseDTO(savedComment);
    }
}
