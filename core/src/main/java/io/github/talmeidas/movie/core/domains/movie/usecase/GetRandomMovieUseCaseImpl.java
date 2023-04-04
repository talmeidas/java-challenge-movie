package io.github.talmeidas.movie.core.domains.movie.usecase;

import io.github.talmeidas.movie.core.domains.movie.model.Movie;
import io.github.talmeidas.movie.core.domains.movie.xcutting.GetAllMoviesCountGateway;
import io.github.talmeidas.movie.core.domains.movie.xcutting.GetRandomMovieGateway;
import io.github.talmeidas.movie.core.exception.NotFoundException;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

@Named
@RequiredArgsConstructor
public class GetRandomMovieUseCaseImpl implements GetRandomMovieUseCase {

        private static final Random random = new SecureRandom();

        private final GetAllMoviesCountGateway getAllMoviesCountGateway;
        private final GetRandomMovieGateway getRandomMovieGateway;

        @Override
        public Movie execute() {
            final long count = getAllMoviesCountGateway.execute();
            final int index = random.nextInt((int) (count));
            final Optional<Movie> optional = getRandomMovieGateway.execute(index);
            return optional.orElseThrow(() -> new NotFoundException("validation.movie.database.empty"));
        }
}
