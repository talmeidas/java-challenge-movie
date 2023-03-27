package io.github.talmeidas.movie.entrypoint.rest.domains.movie;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CountMoviePresenter {

    public static CountMovieResponse of(final Long total) {
        return new CountMovieResponse(total);
    }
}
