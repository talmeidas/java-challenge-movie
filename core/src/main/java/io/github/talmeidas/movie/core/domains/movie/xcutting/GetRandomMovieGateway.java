package io.github.talmeidas.movie.core.domains.movie.xcutting;

import io.github.talmeidas.movie.core.domains.movie.model.Movie;

import java.util.Optional;

@FunctionalInterface
public interface GetRandomMovieGateway {

    Optional<Movie> execute();
}