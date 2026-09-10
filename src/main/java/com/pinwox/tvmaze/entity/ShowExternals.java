package com.pinwox.tvmaze.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowExternals {

    private Long tvrage;
    private Long thetvdb;
    private String imdb;
}