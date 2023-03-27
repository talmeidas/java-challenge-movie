package io.github.talmeidas.movie.entrypoint.rest.domains.movie;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public record MovieResponse(
        Long id,
        String imdbId,
        String title,
        String year,
        String genre,
        Float imdbRating,
        Long imdbVotes,
        Float score,
        String posterUrl)
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 9217004935831572247L;
}
