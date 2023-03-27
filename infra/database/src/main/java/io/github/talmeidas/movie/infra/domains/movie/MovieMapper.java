package io.github.talmeidas.movie.infra.domains.movie;

import io.github.talmeidas.movie.core.domains.movie.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MovieMapper {

    Movie of(final MovieEntity movieEntity);
    @Mapping(target = "score", ignore = true)
    MovieEntity of(final Movie movie);
}
