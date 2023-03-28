package io.github.talmeidas.movie.entrypoint.rest.domains.movie.count;

import io.github.talmeidas.movie.core.domains.movie.model.usecase.GetAllMoviesCountUseCase;
import io.github.talmeidas.movie.entrypoint.rest.common.WebRequest;
import io.github.talmeidas.movie.entrypoint.rest.common.metric.LogExecutionTime;
import io.github.talmeidas.movie.entrypoint.rest.domains.movie.CountMoviePresenter;
import io.github.talmeidas.movie.entrypoint.rest.domains.movie.CountMovieResponse;
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
@RequestMapping("v1/movies")
public class CountMovieController implements CountMovieApiMethod {

    private static final Logger log = LoggerFactory.getLogger(CountMovieController.class);

    private final GetAllMoviesCountUseCase getAllMoviesCountUseCase;
    private final WebRequest webRequest;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public CountMovieResponse execute() {
        log.info("Count Movie Controller -> WebRequest {}", webRequest.toString());
        final Long total = getAllMoviesCountUseCase.execute();
        return CountMoviePresenter.of(total);
    }
}
