
import code.domain.repositories.IUserRepository;
import code.infra.databases.IConnection;
import code.infra.databases.jdbc.postgreSQL.PostgreSQLConnection;
import code.infra.databases.jdbc.postgreSQL.UserDatabase;
import code.infra.framework.IFramework;
import code.infra.framework.quarkus.QuarkusRunner;
import code.infra.framework.spring.SpringRunner;
import code.infra.rest.IController;
import code.infra.rest.UserController;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import io.quarkus.runtime.annotations.QuarkusMain;

@ComponentScan(basePackages = "code")
@SpringBootApplication
@QuarkusMain
public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting application");

        IFramework framework = new SpringRunner();
        framework.runner(Main.class, args);

        logger.info("Application started with framework: {}", getFrameworkRunning(framework));

    }

    private static String getFrameworkRunning(IFramework framework) {
        String frameworkRunning = framework.getClass().getSimpleName();
        return frameworkRunning.replace("Runner", "");
    }

}

/**
 * @package code
 * @brief Package containing project structure.
 */

/**
 * @package code.application
 * @brief Package containing all application related classes.
 */

/**
 * @package code.domain
 * @brief Package containing all domain related classes.
 */

/**
 * @package code.infra
 * @brief Package containing all infrastructure related classes.
 */

//  ==============================================================

/**
 * @package code.domain.entities
 * @brief Package containing all entities.
 */

 /**
 * @package code.domain.repositories
 * @brief Package containing all repositories.
 */

/**
 * @package code.application.use_cases
 * @brief Package containing all use cases.
 */

/**
 * @package code.application.dtos
 * @brief Package containing all data transfer objects.
 */

/**
 * @package code.infra.databases
 * @brief Package containing all database related classes.
 */

/**
 * @package code.infra.rest
 * @brief Package containing all controllers.
 */

/**
 * @package code.infra.env
 * @brief Package containing all environment related classes.
 */

/**
 * @package code.infra.framework
 * @brief Package containing all framework related classes.
 */

/**
 * @package code.util
 * @brief Package containing all utility classes.
 */


