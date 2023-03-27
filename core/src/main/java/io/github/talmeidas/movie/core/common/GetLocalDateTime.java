package io.github.talmeidas.movie.core.common;

import java.time.LocalDateTime;

@FunctionalInterface
public interface GetLocalDateTime {

    LocalDateTime now();
}
