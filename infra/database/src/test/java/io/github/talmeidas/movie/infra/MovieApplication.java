package io.github.talmeidas.movie.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cosium.spring.data.jpa.entity.graph.repository.support.EntityGraphJpaRepositoryFactoryBean;

@EnableJpaRepositories(basePackageClasses = MovieApplication.class, repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class)
@SpringBootApplication(scanBasePackageClasses = {MovieApplication.class}, exclude = {FlywayAutoConfiguration.class})
public class MovieApplication {
    public static void main(final String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }
}
