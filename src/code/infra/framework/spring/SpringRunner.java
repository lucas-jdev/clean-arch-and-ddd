package code.infra.framework.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;

import code.infra.env.EnvironmentVariables;
import code.infra.framework.IFramework;

public class SpringRunner implements IFramework{
  
    private static final Map<String, Object> properties = new HashMap<>();

    public SpringRunner() {
      properties.put("server.port", EnvironmentVariables.get("SPRING_PORT"));
      properties.put("server.servlet.context-path", EnvironmentVariables.get("SPRING_CONTEXT"));
    }

    @Override
    public void runner(Class<?> classMain,String... args) {
        SpringApplication app = new SpringApplication(classMain);
        app.setDefaultProperties(properties);
        app.run(args);
    }
}
