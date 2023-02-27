package code.infra.framework.spring.beans;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import code.infra.env.EnvironmentVariables;

@Configuration
public class DataSourceConfig {

    @Bean
    DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(EnvironmentVariables.get("H2_DRIVER"));
        dataSourceBuilder.url(EnvironmentVariables.get("H2_URL"));
        dataSourceBuilder.username(EnvironmentVariables.get("H2_USER"));
        dataSourceBuilder.password(EnvironmentVariables.get("H2_PASSWORD"));
        return dataSourceBuilder.build();
    }

}
