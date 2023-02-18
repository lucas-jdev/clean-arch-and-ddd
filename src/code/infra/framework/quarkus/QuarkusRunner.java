package code.infra.framework.quarkus;

import io.quarkus.runtime.Quarkus;

import code.infra.framework.IFramework;


public class QuarkusRunner implements IFramework{
    
    @Override
    public void runner(Class<?> classMain,String... args) {
        Quarkus.run(args);
    }

}
