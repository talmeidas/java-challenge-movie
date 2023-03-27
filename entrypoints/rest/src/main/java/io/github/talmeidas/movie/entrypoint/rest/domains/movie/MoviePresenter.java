package io.github.talmeidas.movie.entrypoint.rest.domains.movie;

import io.github.talmeidas.movie.core.domains.movie.model.Movie;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MoviePresenter {

    public static MovieResponse of(final Movie movie) {
        return new MovieResponse(
            movie.id(),
            movie.imdbId(),
            movie.title(),
            movie.year(),
            movie.genre(),
            movie.imdbRating(),
            movie.imdbVotes(),
            movie.score(),
            movie.posterUrl()
        );
    }
}
