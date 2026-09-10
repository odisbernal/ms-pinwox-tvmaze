package com.pinwox.tvmaze.mapper;

import org.springframework.stereotype.Component;

import com.pinwox.tvmaze.dto.response.ShowResponseDTO;
import com.pinwox.tvmaze.dto.response.TvMazeCountryDTO;
import com.pinwox.tvmaze.dto.response.TvMazeExternalsDTO;
import com.pinwox.tvmaze.dto.response.TvMazeImageDTO;
import com.pinwox.tvmaze.dto.response.TvMazeLinkDTO;
import com.pinwox.tvmaze.dto.response.TvMazeLinksDTO;
import com.pinwox.tvmaze.dto.response.TvMazeNetworkDTO;
import com.pinwox.tvmaze.dto.response.TvMazePreviousEpisodeDTO;
import com.pinwox.tvmaze.dto.response.TvMazeRatingDTO;
import com.pinwox.tvmaze.dto.response.TvMazeScheduleDTO;
import com.pinwox.tvmaze.dto.response.TvMazeShowDTO;
import com.pinwox.tvmaze.dto.response.TvMazeWebChannelDTO;
import com.pinwox.tvmaze.entity.Show;
import com.pinwox.tvmaze.entity.ShowCountry;
import com.pinwox.tvmaze.entity.ShowExternals;
import com.pinwox.tvmaze.entity.ShowImage;
import com.pinwox.tvmaze.entity.ShowLink;
import com.pinwox.tvmaze.entity.ShowLinks;
import com.pinwox.tvmaze.entity.ShowNetwork;
import com.pinwox.tvmaze.entity.ShowPreviousEpisode;
import com.pinwox.tvmaze.entity.ShowRating;
import com.pinwox.tvmaze.entity.ShowSchedule;
import com.pinwox.tvmaze.entity.ShowWebChannel;

@Component
public class ShowMapper {

    public ShowResponseDTO toResponseDTO(TvMazeShowDTO show) {

        String channel = null;

        if (show.getNetwork() != null) {
            channel = show.getNetwork().getName();
        } else if (show.getWebChannel() != null) {
            channel = show.getWebChannel().getName();
        }

        return ShowResponseDTO.builder()
                .id(show.getId())
                .name(show.getName())
                .channel(channel)
                .summary(show.getSummary())
                .genres(show.getGenres())
                .build();
    }

    public Show toEntity(TvMazeShowDTO dto) {

        if (dto == null) {
            return null;
        }

        return Show.builder()
                .id(dto.getId())
                .url(dto.getUrl())
                .name(dto.getName())
                .type(dto.getType())
                .language(dto.getLanguage())
                .genres(dto.getGenres())
                .status(dto.getStatus())
                .runtime(dto.getRuntime())
                .averageRuntime(dto.getAverageRuntime())
                .premiered(dto.getPremiered())
                .ended(dto.getEnded())
                .officialSite(dto.getOfficialSite())
                .schedule(toEntity(dto.getSchedule()))
                .rating(toEntity(dto.getRating()))
                .weight(dto.getWeight())
                .network(toEntity(dto.getNetwork()))
                .webChannel(toEntity(dto.getWebChannel()))
                .dvdCountry(toEntity(dto.getDvdCountry()))
                .externals(toEntity(dto.getExternals()))
                .image(toEntity(dto.getImage()))
                .summary(dto.getSummary())
                .updated(dto.getUpdated())
                .links(toEntity(dto.getLinks()))
                .build();
    }

    public TvMazeShowDTO toTvMazeShowDTO(Show entity) {

        if (entity == null) {
            return null;
        }

        return TvMazeShowDTO.builder()
                .id(entity.getId())
                .url(entity.getUrl())
                .name(entity.getName())
                .type(entity.getType())
                .language(entity.getLanguage())
                .genres(entity.getGenres())
                .status(entity.getStatus())
                .runtime(entity.getRuntime())
                .averageRuntime(entity.getAverageRuntime())
                .premiered(entity.getPremiered())
                .ended(entity.getEnded())
                .officialSite(entity.getOfficialSite())
                .schedule(toDto(entity.getSchedule()))
                .rating(toDto(entity.getRating()))
                .weight(entity.getWeight())
                .network(toDto(entity.getNetwork()))
                .webChannel(toDto(entity.getWebChannel()))
                .dvdCountry(toDto(entity.getDvdCountry()))
                .externals(toDto(entity.getExternals()))
                .image(toDto(entity.getImage()))
                .summary(entity.getSummary())
                .updated(entity.getUpdated())
                .links(toDto(entity.getLinks()))
                .build();
    }

    private ShowSchedule toEntity(TvMazeScheduleDTO dto) {

        if (dto == null) {
            return null;
        }

        return ShowSchedule.builder()
                .time(dto.getTime())
                .days(dto.getDays())
                .build();
    }

    private TvMazeScheduleDTO toDto(ShowSchedule entity) {

        if (entity == null) {
            return null;
        }

        return TvMazeScheduleDTO.builder()
                .time(entity.getTime())
                .days(entity.getDays())
                .build();
    }

    private ShowRating toEntity(TvMazeRatingDTO dto) {

        if (dto == null) {
            return null;
        }

        return ShowRating.builder()
                .average(dto.getAverage())
                .build();
    }

    private TvMazeRatingDTO toDto(ShowRating entity) {

        if (entity == null) {
            return null;
        }

        return TvMazeRatingDTO.builder()
                .average(entity.getAverage())
                .build();
    }

    private ShowCountry toEntity(TvMazeCountryDTO dto) {

        if (dto == null) {
            return null;
        }

        return ShowCountry.builder()
                .name(dto.getName())
                .code(dto.getCode())
                .timezone(dto.getTimezone())
                .build();
    }

    private TvMazeCountryDTO toDto(ShowCountry entity) {

        if (entity == null) {
            return null;
        }

        return TvMazeCountryDTO.builder()
                .name(entity.getName())
                .code(entity.getCode())
                .timezone(entity.getTimezone())
                .build();
    }

    private ShowNetwork toEntity(TvMazeNetworkDTO dto) {

        if (dto == null) {
            return null;
        }

        return ShowNetwork.builder()
                .id(dto.getId())
                .name(dto.getName())
                .country(toEntity(dto.getCountry()))
                .officialSite(dto.getOfficialSite())
                .build();
    }

    private TvMazeNetworkDTO toDto(ShowNetwork entity) {

        if (entity == null) {
            return null;
        }

        return TvMazeNetworkDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .country(toDto(entity.getCountry()))
                .officialSite(entity.getOfficialSite())
                .build();
    }

    private ShowWebChannel toEntity(TvMazeWebChannelDTO dto) {

        if (dto == null) {
            return null;
        }

        return ShowWebChannel.builder()
                .id(dto.getId())
                .name(dto.getName())
                .country(toEntity(dto.getCountry()))
                .officialSite(dto.getOfficialSite())
                .build();
    }

    private TvMazeWebChannelDTO toDto(ShowWebChannel entity) {

        if (entity == null) {
            return null;
        }

        return TvMazeWebChannelDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .country(toDto(entity.getCountry()))
                .officialSite(entity.getOfficialSite())
                .build();
    }

    private ShowExternals toEntity(TvMazeExternalsDTO dto) {

        if (dto == null) {
            return null;
        }

        return ShowExternals.builder()
                .tvrage(dto.getTvrage())
                .thetvdb(dto.getThetvdb())
                .imdb(dto.getImdb())
                .build();
    }

    private TvMazeExternalsDTO toDto(ShowExternals entity) {

        if (entity == null) {
            return null;
        }

        return TvMazeExternalsDTO.builder()
                .tvrage(entity.getTvrage())
                .thetvdb(entity.getThetvdb())
                .imdb(entity.getImdb())
                .build();
    }

    private ShowImage toEntity(TvMazeImageDTO dto) {

        if (dto == null) {
            return null;
        }

        return ShowImage.builder()
                .medium(dto.getMedium())
                .original(dto.getOriginal())
                .build();
    }

    private TvMazeImageDTO toDto(ShowImage entity) {

        if (entity == null) {
            return null;
        }

        return TvMazeImageDTO.builder()
                .medium(entity.getMedium())
                .original(entity.getOriginal())
                .build();
    }

    private ShowLinks toEntity(TvMazeLinksDTO dto) {

        if (dto == null) {
            return null;
        }

        return ShowLinks.builder()
                .self(toEntity(dto.getSelf()))
                .previousepisode(toEntity(dto.getPreviousepisode()))
                .build();
    }

    private TvMazeLinksDTO toDto(ShowLinks entity) {

        if (entity == null) {
            return null;
        }

        return TvMazeLinksDTO.builder()
                .self(toDto(entity.getSelf()))
                .previousepisode(toDto(entity.getPreviousepisode()))
                .build();
    }

    private ShowLink toEntity(TvMazeLinkDTO dto) {

        if (dto == null) {
            return null;
        }

        return ShowLink.builder()
                .href(dto.getHref())
                .build();
    }

    private TvMazeLinkDTO toDto(ShowLink entity) {

        if (entity == null) {
            return null;
        }

        return TvMazeLinkDTO.builder()
                .href(entity.getHref())
                .build();
    }

    private ShowPreviousEpisode toEntity(TvMazePreviousEpisodeDTO dto) {

        if (dto == null) {
            return null;
        }

        return ShowPreviousEpisode.builder()
                .href(dto.getHref())
                .name(dto.getName())
                .build();
    }

    private TvMazePreviousEpisodeDTO toDto(ShowPreviousEpisode entity) {

        if (entity == null) {
            return null;
        }

        return TvMazePreviousEpisodeDTO.builder()
                .href(entity.getHref())
                .name(entity.getName())
                .build();
    }

}
