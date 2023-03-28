package io.github.talmeidas.movie.configuration;

import io.github.talmeidas.movie.entrypoint.rest.common.WebRequest;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Profile("test")
@Configuration
public class WebRequestStubConfiguration {
    @Bean
    @Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public WebRequest getWebRequest() {
        return buildWebRequest(getHttpRequest());
    }

    public HttpServletRequest getHttpRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    private WebRequest buildWebRequest(HttpServletRequest request) {
        return new WebRequest(request.getRequestURI());
    }
}
