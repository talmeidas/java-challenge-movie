package io.github.talmeidas.movie.core.common;

import java.time.LocalDate;

@FunctionalInterface
public interface GetLocalDate {

    LocalDate now();
}
