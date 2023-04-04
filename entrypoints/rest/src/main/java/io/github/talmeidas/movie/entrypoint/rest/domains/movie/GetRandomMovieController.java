package io.github.talmeidas.movie.entrypoint.rest.domains.movie;

import io.github.talmeidas.movie.core.domains.movie.model.Movie;
import io.github.talmeidas.movie.core.domains.movie.usecase.GetRandomMovieUseCase;
import io.github.talmeidas.movie.entrypoint.rest.common.WebRequest;
import io.github.talmeidas.movie.entrypoint.rest.common.metric.LogExecutionTime;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/movie/random")
public class GetRandomMovieController implements GetRandomMovieApiMethod {

    private static final Logger log = LoggerFactory.getLogger(GetRandomMovieController.class);

    private final WebRequest webRequest;
    private final GetRandomMovieUseCase getRandomMovieUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public MovieResponse execute() {
        log.info("Starting Controller -> GetRandomMovieController for Player {}", webRequest.getEmail());
        final Movie movie = getRandomMovieUseCase.execute();
        return MoviePresenter.of(movie);
    }
}
