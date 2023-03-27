package io.github.talmeidas.movie.core.exception;

import lombok.Getter;

import java.io.Serial;

public class CoreException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 2361423857513221244L;

    @Getter
    private final String message;

    @Getter
    private final transient Object[] args;

    public CoreException(final String message) {
        super();
        this.message = message;
        this.args = new Object[] {};
    }

    public CoreException(final String message, final Object... args) {
        super();
        this.message = message;
        this.args = args;
    }
}
