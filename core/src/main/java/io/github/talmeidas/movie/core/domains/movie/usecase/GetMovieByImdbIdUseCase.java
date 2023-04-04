package io.github.talmeidas.movie.core.domains.movie.usecase;

import io.github.talmeidas.movie.core.domains.movie.model.Movie;


@FunctionalInterface
public interface GetMovieByImdbIdUseCase {

    Movie execute(final String imdbId);
}
