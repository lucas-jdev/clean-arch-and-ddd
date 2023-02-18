package code.infra.rest;

public interface IController<I,O> {
    
    O findById(String id);

    O save(I entity);

    O update(I entity);

    void delete(String id);

}
