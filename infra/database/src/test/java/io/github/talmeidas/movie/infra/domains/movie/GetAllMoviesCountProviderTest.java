package io.github.talmeidas.movie.infra.domains.movie;

import io.github.talmeidas.movie.infra.MovieApplication;
import io.github.talmeidas.movie.infra.domains.game.GameRepository;
import io.github.talmeidas.movie.infra.domains.game.RegisterGameProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Get All Movies Count Provider Test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Import({GetAllMoviesCountProvider.class})
@Sql("GetAllMoviesCountProviderTest.sql")
class GetAllMoviesCountProviderTest {

    @Autowired
    private GetAllMoviesCountProvider getAllMoviesCountProvider;

    @Autowired
    private MovieRepository movieRepository;

    @DisplayName("Get All Movies Count")
    @Test
    void successfulToGetAllMoviesCount() {
        // Arrange
        // Act
        final Long actual = getAllMoviesCountProvider.execute();

        // Assert
        assertThat(actual).isEqualTo(2L);

        assertThat(movieRepository.count()).isEqualTo(2L);
    }
}
