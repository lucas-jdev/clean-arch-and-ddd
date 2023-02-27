package code.infra.framework.spring.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import code.domain.repositories.IUserRepository;
import code.infra.databases.IConnection;
import code.infra.databases.jdbc.postgreSQL.UserDatabase;

@Configuration
public class IUserRepositoryBean {

    @Bean
    IUserRepository userRepository(IConnection connection) {
        return new UserDatabase(connection);
    }
    
}
