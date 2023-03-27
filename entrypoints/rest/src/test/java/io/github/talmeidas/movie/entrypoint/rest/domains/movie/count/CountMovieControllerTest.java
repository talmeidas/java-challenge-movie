package io.github.talmeidas.movie.entrypoint.rest.domains.movie.count;

import io.github.talmeidas.movie.core.domains.movie.model.usecase.GetAllMoviesCountUseCase;
import io.github.talmeidas.movie.entrypoint.rest.common.WebRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Count Movie Controller Test")
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(SpringExtension.class)
@WebMvcTest
@ContextConfiguration(classes= CountMovieController.class)
class CountMovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetAllMoviesCountUseCase getAllMoviesCountUseCase;

    @MockBean
    private WebRequest webRequest;

    @DisplayName("Successful to start new game")
    @Test
    void SuccessfulToStartNewGame() throws Exception {
        // Arrange
        when(webRequest.getEmail()).thenReturn("joe.doe.one@xyz.com");
        when(webRequest.getFullName()).thenReturn("Joe Doe");

        when(getAllMoviesCountUseCase.execute()).thenReturn(getAllMoviesCount());

        // Act
        // Assert
        mockMvc.perform(post("/v1/movies")
            .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.total", is(10L)));

        verify(getAllMoviesCountUseCase, times(1)).execute();
        verifyNoMoreInteractions(getAllMoviesCountUseCase);
    }

    private static Long getAllMoviesCount() {
        return 10L;
    }
}