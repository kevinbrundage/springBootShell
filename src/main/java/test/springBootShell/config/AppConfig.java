package test.springBootShell.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages = "test.springBootShell.repository")
public class AppConfig {
    private final DataSource dataSource;

    @Autowired
    AppConfig(DataSource dataSource) {

        this.dataSource = dataSource;
    }
}
