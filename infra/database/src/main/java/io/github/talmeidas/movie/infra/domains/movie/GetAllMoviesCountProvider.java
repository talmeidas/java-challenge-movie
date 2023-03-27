package io.github.talmeidas.movie.infra.domains.movie;

import io.github.talmeidas.movie.core.domains.movie.xcutting.GetAllMoviesCountGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GetAllMoviesCountProvider implements GetAllMoviesCountGateway {

    private final MovieRepository movieRepository;

    @Override
    public Long execute() {
        return movieRepository.count();
    }
}