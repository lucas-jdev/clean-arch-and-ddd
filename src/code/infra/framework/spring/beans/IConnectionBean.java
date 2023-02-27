package code.infra.framework.spring.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import code.infra.databases.IConnection;
import code.infra.databases.jdbc.postgreSQL.PostgreSQLConnection;

@Configuration
public class IConnectionBean {

    @Bean
    IConnection connection() {
        return new PostgreSQLConnection();
    }

}
