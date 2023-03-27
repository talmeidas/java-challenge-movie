package io.github.talmeidas.movie.entrypoint.rest.domains.movie;

import java.io.Serial;
import java.io.Serializable;

public record CountMovieResponse(Long total) {

    @Serial
    private static final long serialVersionUID = 9217004935831572247L;
}
