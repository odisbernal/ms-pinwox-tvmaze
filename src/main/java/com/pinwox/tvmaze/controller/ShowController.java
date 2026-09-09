package com.pinwox.tvmaze.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pinwox.tvmaze.dto.response.GenericResponseDTO;
import com.pinwox.tvmaze.dto.response.ShowResponseDTO;
import com.pinwox.tvmaze.dto.response.TvMazeShowDTO;
import com.pinwox.tvmaze.service.ShowService;
import com.pinwox.tvmaze.util.ResponseBuilder;

@RestController
@RequestMapping("/api/shows")
@CrossOrigin(origins = "http://localhost:8080")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/search")
    public ResponseEntity<GenericResponseDTO<List<ShowResponseDTO>>> searchShows(
            @RequestParam("search_query") String searchQuery) {

        return ResponseEntity.ok(
                ResponseBuilder.success(showService.searchShows(searchQuery)));
    }

    @GetMapping("/{showId}")
    public ResponseEntity<TvMazeShowDTO> getShowById(
            @PathVariable Long showId) {

        return ResponseEntity.ok(showService.getShowById(showId));
    }

}
