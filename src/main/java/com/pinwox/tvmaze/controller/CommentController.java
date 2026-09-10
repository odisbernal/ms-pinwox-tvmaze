package com.pinwox.tvmaze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pinwox.tvmaze.dto.request.CommentRequestDTO;
import com.pinwox.tvmaze.dto.response.CommentResponseDTO;
import com.pinwox.tvmaze.dto.response.GenericResponseDTO;
import com.pinwox.tvmaze.service.CommentService;
import com.pinwox.tvmaze.util.ResponseBuilder;


@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "http://localhost:8080")
public class CommentController {


    @Autowired 
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<GenericResponseDTO<CommentResponseDTO>> saveUser(
            @RequestBody CommentRequestDTO request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseBuilder.created(
                        commentService.saveComment(request)));

    }

}
