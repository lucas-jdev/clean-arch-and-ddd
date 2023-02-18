package code.infra.framework;

@FunctionalInterface
public interface IFramework {
    
    void runner(Class<?> classMain,String... args);
}
