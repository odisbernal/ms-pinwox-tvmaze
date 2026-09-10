package com.pinwox.tvmaze.service;

import com.pinwox.tvmaze.dto.request.CommentRequestDTO;
import com.pinwox.tvmaze.dto.response.CommentResponseDTO;

public interface CommentService {

    CommentResponseDTO saveComment(CommentRequestDTO request);

}
