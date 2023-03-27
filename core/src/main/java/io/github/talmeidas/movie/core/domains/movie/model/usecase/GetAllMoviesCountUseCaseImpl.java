package io.github.talmeidas.movie.core.domains.movie.model.usecase;

import io.github.talmeidas.movie.core.domains.movie.xcutting.GetAllMoviesCountGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;


@Named
@RequiredArgsConstructor
public class GetAllMoviesCountUseCaseImpl implements GetAllMoviesCountUseCase {
    private final GetAllMoviesCountGateway getAllMoviesCountGateway;

    @Override
    public Long execute() {
        final Long totalMovie = getAllMoviesCountGateway.execute();

        return totalMovie;
    }
}
