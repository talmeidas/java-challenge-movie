package io.github.talmeidas.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cosium.spring.data.jpa.entity.graph.repository.support.EntityGraphJpaRepositoryFactoryBean;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = MovieApplication.class, repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class)
public class MovieApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }
}
