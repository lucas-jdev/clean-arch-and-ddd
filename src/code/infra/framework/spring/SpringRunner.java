package code.infra.framework.spring;

import java.util.Collections;

import org.springframework.boot.SpringApplication;

import code.infra.framework.IFramework;

public class SpringRunner implements IFramework{
    
    @Override
    public void runner(Class<?> classMain,String... args) {
        SpringApplication app = new SpringApplication(classMain);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8083"));
        app.run(args);
    }
}
