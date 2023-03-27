package io.github.talmeidas.movie.entrypoint.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {MovieApplication.class})
public class MovieApplication {
    public static void main(final String[] args) {
        SpringApplication.run(MovieApplication.class);
    }
}
