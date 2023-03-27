package io.github.talmeidas.movie.infra.domains.movie;

import io.github.talmeidas.movie.core.domains.movie.model.Movie;
import io.github.talmeidas.movie.core.domains.movie.xcutting.GetRandomMovieGateway;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GetRandomMovieProvider implements GetRandomMovieGateway {

    private static final Random random = new SecureRandom();

    private final MovieMapper movieMapper = Mappers.getMapper(MovieMapper.class);

    private final MovieRepository movieRepository;

    @Override
    public Optional<Movie> execute() {
        final long count = movieRepository.count();
        final int index = (int) (random.nextInt() * count);
        final Optional<MovieEntity> optional = movieRepository.findAll(PageRequest.of(index, 1)).stream().findFirst();
        return optional.map(movieMapper::of);
    }
}
