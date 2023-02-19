package code.domain.repositories;

import java.util.Collection;
import java.util.Optional;

import code.domain.entities.user.User;

public interface IUserRepository {

    void save(User user);

    void update(User user);

    Collection<User> findAll();

    Collection<User> findByEmail(String email);

    Collection<User> findByUsername(String username);

    Optional<User> findById(String id);

    void delete(String id);
}
