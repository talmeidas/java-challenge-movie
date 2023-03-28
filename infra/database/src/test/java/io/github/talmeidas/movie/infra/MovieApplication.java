package io.github.talmeidas.movie.infra;

import com.cosium.spring.data.jpa.entity.graph.repository.support.EntityGraphJpaRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(
    basePackageClasses = MovieApplication.class,
    repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class
)
@SpringBootApplication(scanBasePackageClasses = {MovieApplication.class})
public class MovieApplication {
    public static void main(final String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }
}
