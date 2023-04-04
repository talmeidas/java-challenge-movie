package io.github.talmeidas.movie.core.common;

import java.time.LocalDateTime;

import jakarta.inject.Named;


@Named
public class GetLocalDateTimeImpl implements GetLocalDateTime {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
