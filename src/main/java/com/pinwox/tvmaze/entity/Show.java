package com.pinwox.tvmaze.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tvmaze")
public class Show {

    @Id
    private Long id;

    private String url;
    private String name;
    private String type;
    private String language;

    private List<String> genres;

    private String status;

    private Integer runtime;
    private Integer averageRuntime;

    private String premiered;
    private String ended;
    private String officialSite;

    private ShowSchedule schedule;

    private ShowRating rating;

    private Integer weight;

    private ShowNetwork network;

    private ShowWebChannel webChannel;

    private ShowCountry dvdCountry;

    private ShowExternals externals;

    private ShowImage image;

    private String summary;

    private Long updated;

    private ShowLinks links;
}