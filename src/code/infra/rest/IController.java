package code.infra.rest;

public interface IController<I,O> {
    
    O save(I entity);

    O update(I entity);

}
